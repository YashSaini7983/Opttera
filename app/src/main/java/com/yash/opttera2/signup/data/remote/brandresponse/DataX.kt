package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DataX(
    @SerializedName("adapters")
    val adapters: List<Adapter>,
    @SerializedName("availability")
    val availability: Availability,
    @SerializedName("battery")
    val battery: Battery,
    @SerializedName("body")
    val body: Body,
    @SerializedName("connect")
    val connect: Connect,
    @SerializedName("connectors")
    val connectors: List<Connector>,
    @SerializedName("drivetrain")
    val drivetrain: Drivetrain,
    @SerializedName("id")
    val id: String,
    @SerializedName("media")
    val media: Media,
    @SerializedName("naming")
    val naming: Naming,
    @SerializedName("range")
    val range: Range,
    @SerializedName("routing")
    val routing: Routing
)