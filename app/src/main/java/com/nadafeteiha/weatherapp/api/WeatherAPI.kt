package com.nadafeteiha.weatherapp.api

import com.nadafeteiha.weatherapp.api.domain.HourlyWeatherResponse
import com.nadafeteiha.weatherapp.api.domain.WeatherResponse
import com.nadafeteiha.weatherapp.util.Constants
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("v2.0/forecast/daily")
    fun getForecast(
        @Query("key") api: String = Constants.API_KEY,
        @Query("lat") lat: String = "30",
        @Query("lon") lon: String = "31",
        @Query("days") days: Int = 5
    ): Call<WeatherResponse>


    @GET("v2.0/forecast/hourly")
    fun getForecastHourly(
        @Query("key") api: String = Constants.API_KEY,
        @Query("lat") lat: String = "30",
        @Query("lon") lon: String = "31",
        @Query("hours") hours: Int = 24
    ): Call<HourlyWeatherResponse>
}

