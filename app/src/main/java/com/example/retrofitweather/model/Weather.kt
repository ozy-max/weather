package com.example.retrofitweather.model

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)