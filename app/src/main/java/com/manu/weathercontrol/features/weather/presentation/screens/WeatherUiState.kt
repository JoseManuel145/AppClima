package com.manu.weathercontrol.features.weather.presentation.screens

import com.manu.weathercontrol.features.weather.domain.entities.Weather
import com.manu.weathercontrol.features.weather.domain.rules.Recommendation

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val recommendationCodes: List<Recommendation> = emptyList(),
    val error: String? = null
)
