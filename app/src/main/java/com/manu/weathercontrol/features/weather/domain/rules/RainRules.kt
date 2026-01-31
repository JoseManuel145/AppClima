package com.manu.weathercontrol.features.weather.domain.rules

    fun rainLevel(probability: Double): Level =
        when {
            probability < 10 -> Level.VERYLOW
            probability < 30 -> Level.LOW
            probability < 50 -> Level.MODERATE
            probability < 80 -> Level.HIGH
            else -> Level.EXTREME
        }
