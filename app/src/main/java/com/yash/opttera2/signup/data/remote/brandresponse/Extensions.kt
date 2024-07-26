package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Extensions(
    @SerializedName("code")
    val code: String,
    @SerializedName("exception")
    val exception: Exception,
    @SerializedName("serviceName")
    val serviceName: String
)