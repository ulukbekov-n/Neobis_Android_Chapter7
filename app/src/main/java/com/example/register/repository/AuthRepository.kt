package com.example.register.repository

import com.example.register.data.UniqueEmailResponse
import com.example.register.data.ValidateEmailBody
import com.example.register.utils.APIConsumer
import com.example.register.utils.RequestStatus
import com.example.register.utils.SimplifiedMessage
import kotlinx.coroutines.flow.flow


class AuthRepository(private val consumer:APIConsumer) {

    fun validateEmailAddress(body: ValidateEmailBody) = flow{
        emit(RequestStatus.Waiting)
        val response = consumer.validateEmailAddress(body)
        if(response.isSuccessful){
            emit((RequestStatus.Success(response.body()!!)))
        }
        else{
            emit(RequestStatus.Error(SimplifiedMessage.get(response.errorBody()!!.byteStream().reader().readText())))
        }
    }
}