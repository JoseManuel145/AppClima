package com.manu.weathercontrol.features.weather.domain.rules

fun uvLevel(uv: Double): Level =
    when {
        uv < 2 -> Level.VERYLOW
        uv < 4 -> Level.LOW
        uv < 6 -> Level.MODERATE
        uv < 8 -> Level.HIGH
        else -> Level.EXTREME
    }