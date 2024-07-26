package com.yash.opttera2.signup.data.remote.brandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Drivetrain(
    @SerializedName("type")
    val type: String
)