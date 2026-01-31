package com.manu.weathercontrol.features.weather.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manu.weathercontrol.core.providers.LocationProvider
import com.manu.weathercontrol.features.weather.domain.usecases.GetWeatherRecommendationsUseCase
import com.manu.weathercontrol.features.weather.domain.usecases.GetWeatherUseCase
import com.manu.weathercontrol.features.weather.presentation.screens.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getWeatherRecommendationsUseCase: GetWeatherRecommendationsUseCase,
    private val locationProvider: LocationProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState = _uiState.asStateFlow()

    fun loadWeatherWithGps() {
        viewModelScope.launch {
            val location = locationProvider.getLastLocation()
                ?: return@launch

            val weather = getWeatherUseCase(
                latitude = location.latitude,
                longitude = location.longitude
            )
            Log.d("GPS", "LATITUD=${location.latitude}, LONGITUD=${location.longitude}")
            val recommendations = getWeatherRecommendationsUseCase(weather)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    weather = weather,
                    recommendationCodes = recommendations
                )
            }
        }
    }

}
