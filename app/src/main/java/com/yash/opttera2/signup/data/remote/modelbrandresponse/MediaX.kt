package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class MediaX(
    @SerializedName("brand")
    val brand: BrandX,
    @SerializedName("image")
    val image: ImageX,
    @SerializedName("__typename")
    val typename: String
)