package com.yash.opttera2.signup.data.remote


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PhoneNumberResponse(
    @SerializedName("message")
    val message: String
)