package com.example.register.view_model

import android.app.Application
import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.register.data.User
import com.example.register.data.ValidateEmailBody
import com.example.register.repository.AuthRepository

class EmailRegisterFragmentViewModel(val authRepository: AuthRepository, val application: Application):ViewModel() {
    private var isLoading:MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    private var errorMessage:MutableLiveData<HashMap<String,String>> = MutableLiveData()
    private var isUnique: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    private var user: MutableLiveData<User> = MutableLiveData()

    fun getIsLoading():LiveData<Boolean> = isLoading
    fun gerErrorMessage(): LiveData<HashMap<String, String>> = errorMessage
    fun getUnique(): LiveData<Boolean> = isUnique
    fun getUser(): LiveData<User> = user

    fun validateEmailAddress(body: ValidateEmailBody){}
}