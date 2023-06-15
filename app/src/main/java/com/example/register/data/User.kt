package com.example.register.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class User(@SerializedName( "_id")val fullName:String, val email:String,val birthDay: Date  )
