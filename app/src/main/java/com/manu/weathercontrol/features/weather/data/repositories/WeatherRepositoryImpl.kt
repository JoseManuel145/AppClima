package com.manu.weathercontrol.features.weather.data.repositories

import com.manu.weathercontrol.core.network.WeatherApi
import com.manu.weathercontrol.features.weather.data.datasources.remote.mapper.toDomain
import com.manu.weathercontrol.features.weather.domain.entities.Weather
import com.manu.weathercontrol.features.weather.domain.repositories.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double
    ): Weather {
        val response = api.getWeather(
            latitude = latitude,
            longitude = longitude
        )
        return response.toDomain()
    }
}