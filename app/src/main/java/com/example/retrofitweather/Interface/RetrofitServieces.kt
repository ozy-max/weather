package com.example.retrofitweather.Interface


import com.example.retrofitweather.Model.WeatherData
import retrofit2.Call

import retrofit2.http.GET
const val urlWeather :String = "/data/2.5/weather?q=Bishkek&appid=c3c290419df841d24d2577da5e831f02"


interface RetrofitServieces {

    @GET(urlWeather)
    fun getWeatherList(): Call<WeatherData>
}