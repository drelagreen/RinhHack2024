package ru.ssd.hack2024

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ssd.hack2024.ui.theme.Hack2024Theme

data class Config(
    var ClientId: String = "",
    var TransactionId: String = "",
    var Ip: String = "",
    var Mcc: String = "",
    var DeviceType: String = "",
    var DeviceID: String = "",
    var TransactionCode: String = "",
    var CardType: String = "",
    var CardStatus: String = "",
    var OperType: String = "",
    var PinIncorrectFrom: String = "",
    var PinIncorrectTo: String = "",
    var ExpirationDateFrom: String = "",
    var ExpirationDateTo: String = "",
    var TransactionDateFrom: String = "",
    var TransactionDateTo: String = "",
    var SumFrom: String = "",
    var SumTo: String = "",
    var BalanceFrom: String = "",
    var BalanceTo: String = "",
)

@Composable
fun SettingsBottomSheetContent(
    modifier: Modifier = Modifier,
    onSave: (Config) -> Unit,
) {
    var onClientIdTextChanged: String by remember { mutableStateOf("") }
    var onTransactionIdTextChanged: String by remember { mutableStateOf("") }
    var onIpTextChanged: String by remember { mutableStateOf("") }
    var onMccTextChanged: String by remember { mutableStateOf("") }
    var onDeviceTypeTextChanged: String by remember { mutableStateOf("") }
    var onDeviceIDTextChanged: String by remember { mutableStateOf("") }
    var onTransactionCodeTextChanged: String by remember { mutableStateOf("") }
    var onCardTypeTextChanged: String by remember { mutableStateOf("") }
    var onCardStatusTextChanged: String by remember { mutableStateOf("") }
    var onOperTypeTextChanged: String by remember { mutableStateOf("") }
    var onPinIncorrectTextChangedFrom: String by remember { mutableStateOf("") }
    var onPinIncorrectTextChangedTo: String by remember { mutableStateOf("") }
    var onExpirationDateTextChangedFrom: String by remember { mutableStateOf("") }
    var onExpirationDateTextChangedTo: String by remember { mutableStateOf("") }
    var onTransactionDateTextChangedFrom: String by remember { mutableStateOf("") }
    var onTransactionDateTextChangedTo: String by remember { mutableStateOf("") }
    var onSumTextChangedFrom: String by remember { mutableStateOf("") }
    var onSumTextChangedTo: String by remember { mutableStateOf("") }
    var onBalanceTextChangedFrom: String by remember { mutableStateOf("") }
    var onBalanceTextChangedTo: String by remember { mutableStateOf("") }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    "Transaction ID"
                )
                TextField(
                    onTransactionIdTextChanged,
                    { onTransactionIdTextChanged = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Client ID")
                TextField(
                    onClientIdTextChanged,
                    { onClientIdTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Client IP")
                TextField(
                    onIpTextChanged,
                    { onIpTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Transaction Code")
                TextField(
                    onTransactionCodeTextChanged,
                    { onTransactionCodeTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Device Type")
                TextField(
                    onDeviceTypeTextChanged,
                    { onDeviceTypeTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Device ID")
                TextField(
                    onDeviceIDTextChanged,
                    { onDeviceIDTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("MCC")
                TextField(
                    onMccTextChanged,
                    { onMccTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Card Type")
                TextField(
                    onCardTypeTextChanged,
                    { onCardTypeTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Operation Type")
                TextField(
                    onOperTypeTextChanged,
                    { onOperTypeTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Card Status")
                TextField(
                    // selector
                    onCardStatusTextChanged,
                    { onCardStatusTextChanged = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Pin Incorrect Count (From)")
                TextField(
                    onPinIncorrectTextChangedFrom,
                    { onPinIncorrectTextChangedFrom = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Pin Incorrect Count (To)")
                TextField(
                    onPinIncorrectTextChangedTo,
                    { onPinIncorrectTextChangedTo = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Expiration Date (From)")
                TextField(
                    onExpirationDateTextChangedFrom,
                    { onExpirationDateTextChangedFrom = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Expiration Date (To)")
                TextField(
                    onExpirationDateTextChangedTo,
                    { onExpirationDateTextChangedTo = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Pin Incorrect Count (From)")
                TextField(
                    onPinIncorrectTextChangedFrom,
                    { onPinIncorrectTextChangedFrom = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Pin Incorrect Count (To)")
                TextField(
                    onPinIncorrectTextChangedTo,
                    { onPinIncorrectTextChangedTo = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Transaction Date (From)")
                TextField(
                    onTransactionDateTextChangedFrom,
                    { onTransactionDateTextChangedFrom = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Transaction Date (To)")
                TextField(
                    onTransactionDateTextChangedTo,
                    { onTransactionDateTextChangedTo = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Sum (From)")
                TextField(
                    onSumTextChangedFrom,
                    { onSumTextChangedFrom = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Sum (To)")
                TextField(
                    onSumTextChangedTo,
                    { onSumTextChangedTo = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Balance (From)")
                TextField(
                    onBalanceTextChangedFrom,
                    { onBalanceTextChangedFrom = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text("Balance (To)")
                TextField(
                    onBalanceTextChangedTo,
                    { onBalanceTextChangedTo = it },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Button(
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFF28772C),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = {
                onSave(
                    Config(
                        onClientIdTextChanged,
                        onTransactionIdTextChanged,
                        onIpTextChanged,
                        onMccTextChanged,
                        onDeviceTypeTextChanged,
                        onDeviceIDTextChanged,
                        onTransactionCodeTextChanged,
                        onCardTypeTextChanged,
                        onCardStatusTextChanged,
                        onOperTypeTextChanged,
                        onPinIncorrectTextChangedFrom,
                        onPinIncorrectTextChangedTo,
                        onExpirationDateTextChangedFrom,
                        onExpirationDateTextChangedTo,
                        onTransactionDateTextChangedFrom,
                        onTransactionDateTextChangedFrom,
                        onSumTextChangedFrom,
                        onSumTextChangedTo,
                        onBalanceTextChangedFrom,
                        onBalanceTextChangedTo
                    )
                )
            }
        ) {
            Text(
                text ="Сохранить",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
private fun SettingsBottomSheetContentPreview() {
    Hack2024Theme {
        SettingsBottomSheetContent(
            Modifier,
            {}
        )
    }
}