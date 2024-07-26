package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Performance(
    @SerializedName("acceleration")
    val acceleration: Double,
    @SerializedName("top_speed")
    val topSpeed: Int,
    @SerializedName("__typename")
    val typename: String
)