package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class BodyX(
    @SerializedName("height")
    val height: Int,
    @SerializedName("seats")
    val seats: Int,
    @SerializedName("weight")
    val weight: Weight,
    @SerializedName("width")
    val width: Int
)