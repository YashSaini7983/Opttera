package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Battery(
    @SerializedName("full_kwh")
    val fullKwh: Double,
    @SerializedName("usable_kwh")
    val usableKwh: Double
)