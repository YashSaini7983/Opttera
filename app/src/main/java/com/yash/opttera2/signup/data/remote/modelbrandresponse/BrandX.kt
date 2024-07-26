package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class BrandX(
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("__typename")
    val typename: String
)