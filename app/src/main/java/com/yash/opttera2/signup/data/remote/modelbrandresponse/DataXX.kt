package com.yash.opttera2.signup.data.remote.modelbrandresponse


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DataXX(
    @SerializedName("vehicle")
    val vehicle: Vehicle
)