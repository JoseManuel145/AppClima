package com.manu.weathercontrol.features.weather.domain.entities

data class Weather(
    val temperature: Double,
    val humidity: Double,
    val windSpeed: Double,
    val uvIndex: Double,
    val rainProbability: Double,
)
