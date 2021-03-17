package com.example.retrofitweather.`interface`


import com.example.retrofitweather.model.WeatherData
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("data/2.5/weather")
    fun getWeatherList(
        @Query("q") cityName: String,
        @Query("appid") appId: String
    ): Call<WeatherData>
}