package com.manu.weathercontrol.features.weather.data.datasources.remote.mapper

import com.manu.weathercontrol.features.weather.data.datasources.remote.dto.WeatherApiResponse
import com.manu.weathercontrol.features.weather.domain.entities.Weather

fun WeatherApiResponse.toDomain(): Weather {
    return Weather(
        temperature = current.temperature_2m,
        humidity = current.relative_humidity_2m,
        windSpeed = current.wind_speed_10m,
        uvIndex = current.uv_index,
        rainProbability = hourly.precipitation_probability.maxOrNull() ?: 0.0
    )
}
