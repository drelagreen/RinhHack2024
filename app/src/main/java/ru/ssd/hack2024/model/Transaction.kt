package ru.ssd.hack2024.model

import com.google.gson.annotations.SerializedName
import kotlin.random.Random

data class Transaction(
    val id: Int,
    @SerializedName("transaction_id")
    val transactionId: Int,
    @SerializedName("ip")
    val ip: String,
    @SerializedName("device_id")
    val deviceId: Int,
    @SerializedName("device_type")
    val deviceType: String,
    @SerializedName("tran_code")
    val tranCode: String,
    @SerializedName("mcc")
    val mcc: Int,
    @SerializedName("client_id")
    val clientId: Int,
    @SerializedName("card_type")
    val cardType: String,
    @SerializedName("pin_inc_count")
    val pinIncCount: Int,
    @SerializedName("card_status")
    val cardStatus: String,
    @SerializedName("expiration_date")
    val expirationDate: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("sum")
    val sum: Double,
    @SerializedName("oper_type")
    val operType: String,
    @SerializedName("balance")
    val balance: Double,
    @SerializedName("predicted_cluster")
    val predictedCluster: Double,
) {
    private var _warn: Boolean? = null
    val warn: Boolean
        get() {
            if (_warn == null) {
                _warn = Random.nextInt(1, 100) >= 97
            }
            return _warn ?: false
        }

    private var _flag: String? = null
    val flag: String
        get() {
            if (_flag == null) {
                _flag = when (Random.nextInt(1, 10)) {
                    1, 2, 3, 4, 5, 6 -> "\uD83C\uDDF7\uD83C\uDDFA"
                    7, 8 -> "\uD83C\uDDE7\uD83C\uDDFE"
                    9 -> "\uD83C\uDDF0\uD83C\uDDFF"
                    10 -> "\uD83C\uDDE6\uD83C\uDDEA"
                    else -> ""
                }
            }
            return _flag ?: ""
        }

    private var _region: String? = null

    val region: String
        get() {
            if (_region == null) {
                _region = if (flag == "\uD83C\uDDF7\uD83C\uDDFA") {
                    when (Random.nextInt(1, 10)) {
                        1 -> "RND"
                        2 -> "MSK"
                        3 -> "SPB"
                        4 -> "KND"
                        5 -> "KAZ"
                        6 -> "VLK"
                        7 -> "TGN"
                        8 -> "EKT"
                        9 -> "SOC"
                        10 -> "DG"
                        else -> "-"
                    }
                } else ""
            }
            return _region ?: ""
        }
}