package com.nadafeteiha.weatherapp.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.nadafeteiha.weatherapp.adapter.HourlyAdapter
import com.nadafeteiha.weatherapp.adapter.MainAdapter
import com.nadafeteiha.weatherapp.adapter.ParentAdapter
import com.nadafeteiha.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var forecastAdapter: MainAdapter
    private lateinit var hourlyAdapter: HourlyAdapter
    private lateinit var parentHourlyAdapter: ParentAdapter
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupDataInRecyclerView()

        setupObserves()
    }

    private fun setupDataInRecyclerView() {
        hourlyAdapter = HourlyAdapter()
        forecastAdapter = MainAdapter()
        parentHourlyAdapter = ParentAdapter(hourlyAdapter)
        binding.recyclerWeather.adapter = ConcatAdapter(parentHourlyAdapter, forecastAdapter)
        binding.recyclerWeather.layoutManager = GridLayoutManager(this, 1)

    }

    private fun setupObserves() {
        viewModel.hourlyWeatherResponse.observe(this) { response ->
            if (response?.weatherData != null)
                hourlyAdapter.submitList(response.weatherData)
        }

        viewModel.weatherResponse.observe(this) { response ->
            if (response?.weatherData != null)
                forecastAdapter.submitList(response.weatherData)
        }
    }
}

