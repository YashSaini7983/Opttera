package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ConnectorX(
    @SerializedName("standard")
    val standard: String,
    @SerializedName("__typename")
    val typename: String
)