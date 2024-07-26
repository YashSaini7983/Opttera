package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class BrandResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
)