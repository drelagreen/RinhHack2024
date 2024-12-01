package ru.ssd.hack2024

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.ssd.hack2024.ui.theme.Hack2024Theme
import java.sql.Time
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun ClockWidget(
    modifier: Modifier = Modifier,
    isRunning: Boolean,
) {
    var currentTime by remember { mutableStateOf(LocalTime.now()) }

    LaunchedEffect(key1 = isRunning) {
        while (true) {
            if (isRunning) {
                currentTime = LocalTime.now()
            }
            delay(1000)
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
            fontSize = 36.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.SansSerif,
            color = Color(0xFF226225)
        )
        Text(
            text = "31 ноября 2024",
            fontSize = 18.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.SansSerif,
            color = Color(0xFF1A4B1C)
        )
    }
}

@Preview
@Composable
private fun ClockWidgetPreview() {
    Hack2024Theme {
        ClockWidget(isRunning = true)
    }
}