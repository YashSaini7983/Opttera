package com.yash.opttera2.signup.data.remote.brandresponse


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BatteryX(
    @SerializedName("full_kwh")
    val fullKwh: Float,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("usable_kwh")
    val usableKwh: Double
)