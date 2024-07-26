package com.yash.opttera2.common.data.source.remote

import com.yash.opttera2.signup.data.remote.PhoneNumberBody
import com.yash.opttera2.signup.data.remote.PhoneNumberResponse
import com.yash.opttera2.signup.data.remote.SignUpBody
import com.yash.opttera2.signup.data.remote.SignUpEmail
import com.yash.opttera2.signup.data.remote.SignUpEmailResponse
import com.yash.opttera2.signup.data.remote.SignUpResponse
import com.yash.opttera2.signup.data.remote.brandresponse.BrandResponse
import com.yash.opttera2.signup.data.remote.modelbrandresponse.ModelResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RestClient {

    @POST("/v1/api/account/signup/")
    suspend fun signUpApiService(@Body body: SignUpBody) : retrofit2.Response<SignUpResponse>

    @POST("/v1/api/account/is-email-exists/")
    suspend fun signUpEmailExist(@Body body : SignUpEmail) : retrofit2.Response<SignUpEmailResponse>

    @POST("/v1/api/account/is-phone-exists/")
    suspend fun signUpNumberExist(@Body body : PhoneNumberBody) : retrofit2.Response<PhoneNumberResponse>

    @GET("/v1/api/account/brand/")
    suspend fun vehicleBrand(
        @Query("search") search :String ,
        @Query("page") page :Int ,
        @Query("page-size") page_size :Int ) : retrofit2.Response<BrandResponse>

    @GET("v1/api/account/model/{brand_name}/")
    suspend fun modelBrand(
        @Path("brand_name") brandName : String,
        @Query("search") search : String ,
        @Query("page") page :Int ,
        @Query("page_size") pageSize :Int
    ) : retrofit2.Response<ModelResponse>







}