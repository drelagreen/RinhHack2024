package ru.ssd.hack2024

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.ssd.hack2024.api.Service
import ru.ssd.hack2024.model.Transaction
import ru.ssd.hack2024.ui.theme.Hack2024Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitorFragment(modifier: Modifier = Modifier) {
    var isPlayed by remember { mutableStateOf(false) }
    var allTransactions: List<Transaction> by remember { mutableStateOf(emptyList()) }
    var simulatedTransactions: List<Transaction> by remember { mutableStateOf(listOf()) }
    var savedSimulatedTransactions: List<Transaction> by remember { mutableStateOf(listOf()) }
    var showSettings by remember { mutableStateOf(false) }
    var isDemo by remember { mutableStateOf(true) }
    var config by remember { mutableStateOf(Config()) }
    var isAnaliz by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        launch(Dispatchers.IO) {
            allTransactions = Service.loadAllTransactions()
        }
    }

    LaunchedEffect(config) {
        if (config != Config()) {
            isDemo = false
        }
        simulatedTransactions = checkFilters(config, allTransactions)
    }

    LaunchedEffect(allTransactions) {
        if (allTransactions.isNotEmpty()) {
            val iterator = allTransactions.iterator()
            while (iterator.hasNext() && isDemo) {
                val value = iterator.next()
                if (isPlayed) {
                    if (savedSimulatedTransactions.isNotEmpty()) {
                        simulatedTransactions = simulatedTransactions + savedSimulatedTransactions
                        savedSimulatedTransactions = emptyList()
                    }
                    simulatedTransactions = simulatedTransactions + value
                } else {
                    savedSimulatedTransactions = savedSimulatedTransactions + value
                }
                delay(500L)
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFEFEFEF)
            )
    ) {
        /* TOP TOOLBAR */
        Card(
            modifier = Modifier.padding(bottom = 2.dp),
            shape = RoundedCornerShape(0.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 32.dp,
                                top = 32.dp,
                                bottom = 32.dp,
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                enabled = true,
                                indication = rememberRipple(bounded = false)
                            ) {
                                isAnaliz = false
                            },
                        text = "Монитор",
                        fontSize = 40.sp,
                        color = if (!isAnaliz) Color(0xFF28772C) else Color(0xFF7A7A7A),
                        fontWeight = FontWeight.W500,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        modifier = Modifier
                            .padding(32.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                enabled = true,
                                indication = rememberRipple(bounded = false)
                            ) {
                                isAnaliz = true
                            },
                        text = "Анализ",
                        fontSize = 40.sp,
                        color = if (!isAnaliz) Color(0xFF7A7A7A) else Color(0xFF28772C) ,
                        fontWeight = FontWeight.W500,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(Modifier.weight(1f))
                    ClockWidget(
                        modifier = Modifier.padding(end = 32.dp),
                        isRunning = isPlayed,
                    )
                    IconButton(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(72.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                enabled = true,
                                indication = rememberRipple(bounded = false)
                            ) {},
                        onClick = { isPlayed = !isPlayed }
                    ) {
                        Icon(
                            modifier = Modifier.size(72.dp),
                            imageVector = ImageVector.vectorResource(
                                if (isPlayed) {
                                    R.drawable.ic_pause
                                } else {
                                    R.drawable.ic_play
                                }
                            ),
                            contentDescription = null,
                            tint = Color(0xFF4E524E)
                        )
                    }
                    IconButton(
                        modifier = Modifier
                            .padding(end = 32.dp)
                            .size(72.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                enabled = true,
                                indication = rememberRipple(bounded = false)
                            ) {},
                        onClick = {
                            showSettings = true
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(72.dp),
                            imageVector = ImageVector.vectorResource(
                                R.drawable.ic_settings
                            ),
                            contentDescription = null,
                            tint = Color(0xFF4E524E)
                        )

                    }
                }
            }
        }

        if (!isAnaliz) {
            GeneralTransactionsList(simulatedTransactions) {
                isAnaliz = true
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Image(painterResource(R.drawable.graph),"content description")
            }
        }
    }


    if (showSettings) {
        ModalBottomSheet(onDismissRequest = { showSettings = false }) {
            SettingsBottomSheetContent(
                modifier,
            ) { config = it }
        }
    }
}

private fun checkFilters(
    config: Config,
    list: List<Transaction>
): List<Transaction> {
    return list.filter {
        if (config.Mcc.isNotEmpty()) {
            it.mcc == config.Mcc.toInt()
        } else {
            true
        }
    }.filter {
        if (config.SumFrom.isNotEmpty()) {
            it.sum >= config.SumFrom.toDouble()
        } else {
            true
        }
    }.filter {
        if (config.SumTo.isNotEmpty()) {
            it.sum <= config.SumTo.toDouble()
        } else {
            true
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
private fun MonitorFragmentPreview() {
    Hack2024Theme {
        MonitorFragment()
    }
}