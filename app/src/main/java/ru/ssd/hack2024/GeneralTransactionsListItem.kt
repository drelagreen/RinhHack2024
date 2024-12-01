package ru.ssd.hack2024

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ssd.hack2024.model.Transaction
import ru.ssd.hack2024.ui.theme.Hack2024Theme
import kotlin.random.Random

@Composable
fun GeneralTransactionsListItem(
    data: Transaction,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text( // id
                data.transactionId.toString(),
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp
            )
            delimiter()
            Text( // timestamp
                data.datetime,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp
            )
            delimiter()
            Text( // client id
                "CD: ${data.clientId}",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp

            )
            delimiter()
            Text(
                // card status
                "CS: ${data.cardStatus}(${data.pinIncCount})",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text( // card type
                if (data.cardType.contains("c")) "C" else "D",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp,
                color = if (data.cardType.contains("c")) Color.Magenta else Color.Blue
            )
            delimiter()
            Text(
                // device type
                "DT: \"${data.deviceType}\"",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text(
                // ip
                "IP: ${data.ip} (${data.flag} ${data.region})",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text(
                // device id
                "DID: ${data.deviceId}",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text(
                // oper type
                "OT: ${data.operType}",
                modifier = Modifier.padding(start = 4.dp, end = 8.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text(
                // mcc
                "MCC: ${data.mcc}",
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text(
                // balance
                "BALANCE: ${data.balance} RUB",
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                fontSize = 12.sp,
            )
            delimiter()
            Text(
                // sum
                "SUM:",
                modifier = Modifier.padding(start = 8.dp, end = 4.dp),
                fontSize = 12.sp,
            )
            Text( // sum
                "${data.sum}",
                modifier = Modifier.padding(end = 8.dp),
                fontSize = 12.sp,
                fontWeight = W500,
                color = Color(0xFF2B5D2B)
            )
            delimiter()
            Text(
                // transaction code
                "TC: ${data.tranCode}",
                modifier = Modifier.padding(start = 8.dp, end = 4.dp),
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
private fun delimiter() {
    Box(
        modifier = Modifier
            .size(
                width = 0.5.dp,
                height = 12.dp
            )
            .background(
                color = Color.Gray
            )
    )
}

@Preview(device = Devices.TABLET)
@Composable
private fun ListItemPreview() {
    Hack2024Theme {
//        GeneralTransactionsListItem()
    }
}