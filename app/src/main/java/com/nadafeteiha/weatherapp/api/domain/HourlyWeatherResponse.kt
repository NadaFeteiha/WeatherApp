package com.nadafeteiha.weatherapp.api.domain

import com.google.gson.annotations.SerializedName

data class HourlyWeatherResponse(
    val city_name: String,
    val country_code: String,
    @SerializedName("data")
    val weatherData: List<DataHourly>,
    val lat: Int,
    val lon: Int,
)