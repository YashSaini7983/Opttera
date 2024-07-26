package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class NamingX(
    @SerializedName("chargetrip_version")
    val chargetripVersion: String,
    @SerializedName("edition")
    val edition: Any,
    @SerializedName("make")
    val make: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("version")
    val version: String
)