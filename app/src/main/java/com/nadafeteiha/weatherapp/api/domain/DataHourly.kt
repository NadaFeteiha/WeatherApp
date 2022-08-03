package com.nadafeteiha.weatherapp.api.domain

data class DataHourly(
    val temp: Double,
    val weather: Weather,
    val timestamp_utc: String
)