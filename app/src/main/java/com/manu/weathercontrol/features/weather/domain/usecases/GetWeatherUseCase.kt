package com.manu.weathercontrol.features.weather.domain.usecases

import com.manu.weathercontrol.features.weather.domain.entities.Weather
import com.manu.weathercontrol.features.weather.domain.repositories.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double
    ): Weather {
        return repository.getCurrentWeather(latitude, longitude)
    }
}
