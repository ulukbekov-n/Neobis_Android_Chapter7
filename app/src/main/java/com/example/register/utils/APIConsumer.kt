package com.example.register.utils

import com.example.register.data.UniqueEmailResponse
import com.example.register.data.ValidateEmailBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsumer {
    @POST("users/validate-unique-email")
    suspend fun validateEmailAddress(@Body body:ValidateEmailBody): Response<UniqueEmailResponse>
}