package com.example.register.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.register.repository.AuthRepository
import java.security.InvalidParameterException

class EmailRegisterFragmentViewModelFactory(val authRepository: AuthRepository, val application: Application): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmailRegisterFragmentViewModel::class.java)){
            return EmailRegisterFragmentViewModel(authRepository, application ) as T
        }
        throw InvalidParameterException("Unable to construct RegisterActivityViewModel")
    }
}