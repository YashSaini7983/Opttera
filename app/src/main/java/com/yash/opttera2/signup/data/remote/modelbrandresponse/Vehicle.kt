package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Vehicle(
    @SerializedName("battery")
    val battery: BatteryX,
    @SerializedName("connectors")
    val connectors: List<ConnectorX>,
    @SerializedName("media")
    val media: MediaX,
    @SerializedName("naming")
    val naming: NamingX,
    @SerializedName("performance")
    val performance: Performance,
    @SerializedName("range")
    val range: RangeX,
    @SerializedName("routing")
    val routing: RoutingX,
    @SerializedName("__typename")
    val typename: String
)