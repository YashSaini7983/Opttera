package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RangeX(
    @SerializedName("best")
    val best: Best,
    @SerializedName("chargetrip_range")
    val chargetripRange: ChargetripRangeX,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("worst")
    val worst: Worst
)