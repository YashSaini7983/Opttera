package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Media(
    @SerializedName("brand")
    val brand: Brand,
    @SerializedName("image")
    val image: Image,
    @SerializedName("video")
    val video: Video
)