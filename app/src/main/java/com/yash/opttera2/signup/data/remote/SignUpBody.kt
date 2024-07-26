package com.yash.opttera2.signup.data.remote


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
                         
@Keep
data class SignUpBody(

    @SerializedName("confirm_password")
    val confirmPassword: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("device_type")
    val deviceType: String,
    @SerializedName("re_captcha")
    val reCaptcha : String

)