package com.example.retrofitweather.Common

import com.example.retrofitweather.Interface.RetrofitServieces
import com.example.retrofitweather.Retrofit.RetrofitClient


object Common {
    private val BASE_URL = "http://api.openweathermap.org/"
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServieces::class.java)

}


