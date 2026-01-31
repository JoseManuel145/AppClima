package com.manu.weathercontrol.features.weather.domain.rules
fun windLevel(speed: Double): Level =
    when {
        speed < 10 -> Level.VERYLOW
        speed < 15 -> Level.LOW
        speed < 25 -> Level.MODERATE
        speed < 35 -> Level.HIGH
        else -> Level.EXTREME
    }