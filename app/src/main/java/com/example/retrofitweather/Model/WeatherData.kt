package com.example.retrofitweather.Model

data class WeatherData(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Int,
    val dt: Long,
    val sys: List<Sys>,
    val timezone: Int,
    val id: Int,
    val name: String,
    val code: Int

) {

}
