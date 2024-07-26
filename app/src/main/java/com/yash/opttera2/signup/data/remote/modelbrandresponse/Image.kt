package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Image(
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("thumbnail_height")
    val thumbnailHeight: Int,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("thumbnail_width")
    val thumbnailWidth: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)