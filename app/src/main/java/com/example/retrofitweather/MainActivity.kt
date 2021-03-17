package com.example.retrofitweather

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitweather.`interface`.RetrofitServices
import com.example.retrofitweather.model.WeatherData
import com.example.retrofitweather.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api: RetrofitServices = RetrofitClient.getClient().create(RetrofitServices::class.java)

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: MyWeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val key = getString(R.string.weather_api_key)

        api.getWeatherList("Moscow", key).enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    city_name.text = data.name
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Log.e("Error", "Error getting weather", t)
                Toast.makeText(this@MainActivity, "Error, ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

//retrofit builder + запрос
//retrofit services
//getweatherList

