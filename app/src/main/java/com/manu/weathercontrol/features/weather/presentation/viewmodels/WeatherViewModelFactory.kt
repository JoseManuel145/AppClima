package com.manu.weathercontrol.features.weather.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manu.weathercontrol.core.providers.LocationProvider
import com.manu.weathercontrol.features.weather.domain.usecases.GetWeatherRecommendationsUseCase
import com.manu.weathercontrol.features.weather.domain.usecases.GetWeatherUseCase

class WeatherViewModelFactory(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getWeatherRecommendationsUseCase: GetWeatherRecommendationsUseCase,
    private val locationProvider: LocationProvider
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WeatherViewModel(getWeatherUseCase, getWeatherRecommendationsUseCase, locationProvider = locationProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}