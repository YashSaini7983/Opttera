package com.yash.opttera2.signup.data.remote.brandresponse


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ConnectorX(
    @SerializedName("max_electric_power")
    val maxElectricPower: Float,
    @SerializedName("power")
    val power: Float,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("standard")
    val standard: String,
    @SerializedName("time")
    val time: Int,
    @SerializedName("__typename")
    val typename: String
)