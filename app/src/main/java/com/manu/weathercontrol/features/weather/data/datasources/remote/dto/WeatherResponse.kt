package com.manu.weathercontrol.features.weather.data.datasources.remote.dto

data class WeatherApiResponse(
    val current: WeatherCurrentDto,
    val hourly: WeatherHourlyDto
)

data class WeatherCurrentDto(
    val temperature_2m: Double,
    val relative_humidity_2m: Double,
    val wind_speed_10m: Double,
    val precipitation_probability: Double,
    val uv_index: Double
)
data class WeatherHourlyDto(
    val precipitation_probability: List<Double>
)
/*
{
    "latitude": 18.0,
    "longitude": -93.0,
    "generationtime_ms": 424.57711696624756,
    "utc_offset_seconds": -21600,
    "timezone": "America/Mexico_City",
    "timezone_abbreviation": "GMT-6",
    "elevation": 23.0,
    "current_units": {
        "time": "iso8601",
        "interval": "seconds",
        "temperature_2m": "°C",
        "relative_humidity_2m": "%",
        "uv_index": "",
        "wind_speed_10m": "km/h"
    },
    "current": { <- TOMAMOS CURRENT
        "time": "2026-01-30T20:00",
        "interval": 900,
        "temperature_2m": 20.0, <- TOMAMOS ESTO
        "relative_humidity_2m": 86, <- TOMAMOS ESTO
        "uv_index": 0.00, <- TOMAMOS ESTO
        "wind_speed_10m": 3.6 <- TOMAMOS ESTO
    },
    "hourly_units": {
        "time": "iso8601",
        "precipitation_probability": "%"
    },
    "hourly": { <- TOMAMOS HOURLY
        "time": [
            "2026-01-30T00:00",
            "2026-01-30T01:00"
        ],
        "precipitation_probability": [ <- TOMAMOS ESTO
            0,
            0
        ]
    }
}
 */