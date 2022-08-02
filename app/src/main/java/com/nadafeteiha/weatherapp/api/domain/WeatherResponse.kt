package com.nadafeteiha.weatherapp.api.domain

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val city_name: String,
    val country_code: String,
    @SerializedName("data")
    val weatherData: List<Data>,
    val lat: Double,
    val lon: Double,
)