package ru.ssd.hack2024

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ssd.hack2024.model.Transaction

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GeneralTransactionsList(
    data: List<Transaction>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val state = rememberLazyListState()
    LaunchedEffect(data.size) {
        if (data.isNotEmpty())
            state.animateScrollToItem(data.size - 1)
    }

    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = PaddingValues(2.dp),
        reverseLayout = true
    ) {
        items(data) { datum ->
            GeneralTransactionsListItem(
                data = datum,
                modifier = Modifier
                    .padding(top = 1.dp, bottom = 1.dp)
                    .background(
                        if (datum.predictedCluster == 7.0) {
                            Color(0xFFFF99A8)
                        } else if (datum.predictedCluster == 8.0) {
                            Color(0xFFFFB999)
                        } else if (datum.predictedCluster == 13.0) {
                            Color(0xFFFFE999)
                        } else {
                            Color.White
                        }
                    )
                    .animateItemPlacement().clickable {
                        onClick()
                    }
            )
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
private fun GeneralTransactionsListPreview() {
//    GeneralTransactionsList(emptyList())
}