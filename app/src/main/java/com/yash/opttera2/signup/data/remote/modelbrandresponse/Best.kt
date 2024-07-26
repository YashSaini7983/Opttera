package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Best(
    @SerializedName("city")
    val city: Int,
    @SerializedName("combined")
    val combined: Int,
    @SerializedName("highway")
    val highway: Int,
    @SerializedName("__typename")
    val typename: String
)