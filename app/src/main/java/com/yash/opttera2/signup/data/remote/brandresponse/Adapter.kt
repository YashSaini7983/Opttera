package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Adapter(
    @SerializedName("max_electric_power")
    val maxElectricPower: Double,
    @SerializedName("power")
    val power: Double,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("standard")
    val standard: String,
    @SerializedName("time")
    val time: Int
)