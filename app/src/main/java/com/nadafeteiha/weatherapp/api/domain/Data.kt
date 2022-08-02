package com.nadafeteiha.weatherapp.api.domain

data class Data(
    val high_temp: Double,
    val low_temp: Double,
    val weather: Weather,
    val datetime: String,
    val temp: Double
)