package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Error(
    @SerializedName("extensions")
    val extensions: Extensions,
    @SerializedName("message")
    val message: String,
    @SerializedName("path")
    val path: List<String>
)