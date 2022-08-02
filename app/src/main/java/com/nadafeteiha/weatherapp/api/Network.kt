package com.nadafeteiha.weatherapp.api

import com.nadafeteiha.weatherapp.api.domain.HourlyWeatherResponse
import com.nadafeteiha.weatherapp.api.domain.WeatherResponse
import com.nadafeteiha.weatherapp.util.Constants.BASE_URL
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    private val service: WeatherAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<WeatherResponse>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }

    fun getForecastHourly(callback: Callback<HourlyWeatherResponse>) {
        val call = service.getForecastHourly()
        call.enqueue(callback)
    }
}
