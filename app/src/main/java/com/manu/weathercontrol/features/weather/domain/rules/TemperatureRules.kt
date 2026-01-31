package com.manu.weathercontrol.features.weather.domain.rules

fun temperatureLevel(temp: Double): Level =
    when {
        temp < 10 -> Level.VERYLOW
        temp < 20 -> Level.LOW
        temp < 25 -> Level.MODERATE
        temp < 30 -> Level.HIGH
        else -> Level.EXTREME
    }