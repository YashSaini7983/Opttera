package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Weight(
    @SerializedName("maximal")
    val maximal: Any,
    @SerializedName("minimum")
    val minimum: Any,
    @SerializedName("nominal")
    val nominal: Int
)