package com.yash.opttera2.signup.data.remote.brandresponse


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MediaX(
    @SerializedName("brand")
    val brand: BrandX,
    @SerializedName("image")
    val image: ImageX,
    @SerializedName("image_list")
    val imageList: List<ImageX>,
    @SerializedName("__typename")
    val typename: String,
//    @SerializedName("video")
//    val video: VideoX,
    @SerializedName("video_list")
    val videoList: List<Any>
)