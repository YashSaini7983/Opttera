package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ChargetripRange(
    @SerializedName("best")
    val best: Int,
    @SerializedName("worst")
    val worst: Int
)