package com.yash.opttera2.signup.data.remote.brandresponse


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Vehicle(
    @SerializedName("adapters")
    val adapters: List<Any>,
    @SerializedName("availability")
    val availability: Availability,
    @SerializedName("battery")
    val battery: BatteryX,
    @SerializedName("body")
    val body: BodyX,
//    @SerializedName("connect")
//    val connect: ConnectX,
    @SerializedName("connectors")
    val connectors: List<ConnectorX>,
//    @SerializedName("drivetrain")
//    val drivetrain: DrivetrainX,
    @SerializedName("id")
    val id: String,
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