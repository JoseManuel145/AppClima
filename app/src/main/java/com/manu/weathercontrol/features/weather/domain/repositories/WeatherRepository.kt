package com.manu.weathercontrol.features.weather.domain.repositories

import com.manu.weathercontrol.features.weather.domain.entities.Weather

interface WeatherRepository {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): Weather
}