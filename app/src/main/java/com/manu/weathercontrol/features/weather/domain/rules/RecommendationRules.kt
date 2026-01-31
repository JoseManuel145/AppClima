package com.manu.weathercontrol.features.weather.domain.rules

import com.manu.weathercontrol.features.weather.domain.entities.Weather

fun generateRecommendations(weather: Weather): List<Recommendation> {
    return generateRecommendationCodes(weather)
        .map { it.toRecommendation() }
}

private fun generateRecommendationCodes(weather: Weather): Set<RecommendationCode> {
    val codes = mutableSetOf<RecommendationCode>()

    // Temperatura
    when (temperatureLevel(weather.temperature)) {
        Level.VERYLOW -> {
            codes += RecommendationCode.USE_COAT
            codes += RecommendationCode.WEAR_THERMAL_CLOTHING
            codes += RecommendationCode.EAT_WARM_MEALS
        }
        Level.LOW -> {
            codes += RecommendationCode.USE_JACKET
        }
        Level.MODERATE -> {
            codes += RecommendationCode.WEAR_LIGHT_CLOTHING
        }
        Level.HIGH -> {
            codes += RecommendationCode.STAY_HYDRATED
        }
        Level.EXTREME -> {
            codes += RecommendationCode.EAT_LIGHT_MEALS
            codes += RecommendationCode.AVOID_HEAVY_MEALS
            codes += RecommendationCode.STAY_HYDRATED
            codes += RecommendationCode.AVOID_SUN_EXPOSURE
        }
    }

    // UV
    when (uvLevel(weather.uvIndex)) {
        Level.MODERATE -> {
            codes += RecommendationCode.USE_HAT
        }
        Level.HIGH, Level.EXTREME -> {
            codes += RecommendationCode.USE_SUNSCREEN
            codes += RecommendationCode.USE_HAT
            codes += RecommendationCode.WEAR_SUN_GLASSES
            codes += RecommendationCode.AVOID_SUN_EXPOSURE
        }
        else -> Unit
    }

    // Lluvia
    when (rainLevel(weather.rainProbability)) {
        Level.MODERATE -> {
            codes += RecommendationCode.USE_UMBRELLA
        }
        Level.HIGH, Level.EXTREME -> {
            codes += RecommendationCode.USE_UMBRELLA
            codes += RecommendationCode.WEAR_WATERPROOF_CLOTHING
        }
        else -> Unit
    }

    // Viento
    when (windLevel(weather.windSpeed)) {
        Level.HIGH -> {
            codes += RecommendationCode.SECURE_OBJECTS
        }
        Level.EXTREME -> {
            codes += RecommendationCode.SECURE_OBJECTS
            codes += RecommendationCode.AVOID_HIGH_PLACES
            codes += RecommendationCode.AVOID_OUTDOORS
        }
        else -> Unit
    }

    // Regla compuesta
    if (
        rainLevel(weather.rainProbability) >= Level.MODERATE &&
        temperatureLevel(weather.temperature) <= Level.MODERATE
    ) {
        codes += RecommendationCode.AVOID_COLD_DRINKS
    }

    return codes
}
