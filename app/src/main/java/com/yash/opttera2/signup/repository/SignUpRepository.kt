package com.yash.opttera2.signup.repository

import com.yash.opttera2.common.data.source.remote.RestClient
import com.yash.opttera2.signup.data.remote.PhoneNumberBody
import com.yash.opttera2.signup.data.remote.PhoneNumberResponse
import com.yash.opttera2.signup.data.remote.SignUpBody
import com.yash.opttera2.signup.data.remote.SignUpEmail
import com.yash.opttera2.signup.data.remote.SignUpEmailResponse
import com.yash.opttera2.signup.data.remote.SignUpResponse
import com.yash.opttera2.signup.data.remote.brandresponse.BrandResponse
import com.yash.opttera2.signup.data.remote.modelbrandresponse.ModelResponse
import javax.inject.Inject


class SignUpRepository @Inject constructor(private val restClient: RestClient) {

    suspend fun signUpApiServiceRepo(body: SignUpBody): Result<SignUpResponse> {

        return try {
            // Make the API call
            val response = restClient.signUpApiService(body)
            // Extract the response body
            val responseBody = response.body()
            // Check if the response is successful and the body is not null
            if (response.isSuccessful && responseBody != null) {
                // Return a successful Result with the response body
                Result.success(responseBody)
            } else if (responseBody != null) {
                // If the response is not successful but the body is not null,
                // return a failure Result with the response body (assuming it contains error details)
                Result.failure(Throwable(responseBody.message))
            } else {
                // If the response body is null, return a failure Result with a generic error message
                Result.failure(Throwable("Unknown error occurred"))
            }
        } catch (e: Exception) {
            // If an exception occurs, return a failure Result with the exception
            Result.failure(e)
        }
    }

    suspend fun signUpEmailExist(body: SignUpEmail): Result<SignUpEmailResponse> {
        return try {
            // Make the API call
            val response = restClient.signUpEmailExist(body)
            // Extract the response body
            val responseBody = response.body()

            // Check if the response is successful and the body is not null
            if (response.isSuccessful && responseBody != null) {
                // Return a successful Result with the response body
                Result.success(responseBody)
            } else if (responseBody != null) {
                // If the response is not successful but the body is not null,
                // return a failure Result with the response body (assuming it contains error details)
                Result.failure(Throwable(responseBody.message))
            } else {
                // If the response body is null, return a failure Result with a generic error message
                Result.failure(Throwable("Unknown error occurred"))
            }
        } catch (e: Exception) {
            // If an exception occurs, return a failure Result with the exception
            Result.failure(e)
        }

    }

    suspend fun signUpPhoneExist(body: PhoneNumberBody): Result<PhoneNumberResponse> {
        return try {

            val response = restClient.signUpNumberExist(body)
            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null) {
                Result.success(responseBody)
            } else if (responseBody != null) {
                Result.failure(Throwable(responseBody.message))
            } else {
                // If the response body is null, return a failure Result with a generic error message
                Result.failure(Throwable("Unknown error occurred"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private var currentPage = 1
    private var isLastPage = false

    suspend fun vehicleBrand(search: String, page: Int, pageSize: Int): Result<BrandResponse> {

        if (isLastPage && page > currentPage) {
            return Result.failure(Exception("No more pages"))
        }
        return try {
            val response = restClient.vehicleBrand(search, page, pageSize)
            val data = response.body()
            if (response.isSuccessful) {
                if (data != null) {
                    currentPage = page
                    isLastPage = false
                    Result.success(data)
                } else {
                    Result.failure(Exception("No data found"))
                }
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun modelBrand(
        brandName: String,
        search: String,
        page: Int,
        pageSize: Int
    ): Result<ModelResponse> {

        if (isLastPage && page > currentPage) {
            return Result.failure(Exception("No more pages"))
        }
        return try {
            val response = restClient.modelBrand(brandName, search, page, pageSize)
            val data = response.body()
            if (response.isSuccessful) {
                if (data != null) {
                    currentPage = page
                    isLastPage = false
                    Result.success(data)
                } else {
                    Result.failure(Exception("No data Found "))
                }
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}