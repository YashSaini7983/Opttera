package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RoutingX(
    @SerializedName("fast_charging_support")
    val fastChargingSupport: Boolean,
    @SerializedName("__typename")
    val typename: String
)