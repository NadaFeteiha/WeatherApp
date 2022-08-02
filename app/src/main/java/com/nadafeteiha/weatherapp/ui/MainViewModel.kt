package com.nadafeteiha.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nadafeteiha.weatherapp.api.Network
import com.nadafeteiha.weatherapp.api.domain.HourlyWeatherResponse
import com.nadafeteiha.weatherapp.api.domain.WeatherResponse
import retrofit2.Call
import retrofit2.Response

class MainViewModel :ViewModel() {
    private val weatherService by lazy { Network() }

    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    val weatherResponse: LiveData<WeatherResponse>
        get() = _weatherResponse

    private val _hourlyWeatherResponse = MutableLiveData<HourlyWeatherResponse>()
    val hourlyWeatherResponse: LiveData<HourlyWeatherResponse>
        get() = _hourlyWeatherResponse


    init {
        getWeather()
        getHourlyWeather()
    }


    private fun getWeather(){
        weatherService.getForecast(object : retrofit2.Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    _weatherResponse.value = response.body()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun getHourlyWeather(){
        weatherService.getForecastHourly(object : retrofit2.Callback<HourlyWeatherResponse> {
            override fun onResponse(
                call: Call<HourlyWeatherResponse>,
                response: Response<HourlyWeatherResponse>
            ) {
                if (response.isSuccessful) {
                    _hourlyWeatherResponse.value = response.body()
                }
            }

            override fun onFailure(call: Call<HourlyWeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}