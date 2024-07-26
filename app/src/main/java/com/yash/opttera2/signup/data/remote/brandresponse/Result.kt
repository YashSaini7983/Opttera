package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Result(
    @SerializedName("brand_thumbnail_url")
    val brandThumbnailUrl: String,
    @SerializedName("brand_url")
    val brandUrl: String,
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("default_set")
    val defaultSet: Boolean,
    @SerializedName("details")
    val details: Details,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("url")
    val url: String
)