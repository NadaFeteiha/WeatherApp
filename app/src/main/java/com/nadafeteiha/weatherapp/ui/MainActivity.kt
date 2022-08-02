package com.nadafeteiha.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nadafeteiha.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var adapterHourly: HourlyAdapter
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        binding.recyclerWeather.layoutManager = GridLayoutManager(this, 1)
        adapter = MainAdapter()
        binding.recyclerWeather.adapter = adapter

        viewModel.weatherResponse.observe(this) { response ->
            if (response?.weatherData != null)
                adapter.submitList(response.weatherData)
        }

        // *************** secand adapter
        adapterHourly = HourlyAdapter()
        binding.recyclerHourly.adapter = adapterHourly
        viewModel.hourlyWeatherResponse.observe(this) { response ->
            if (response?.weatherData != null)
                adapterHourly.submitList(response.weatherData)
        }
    }
}

