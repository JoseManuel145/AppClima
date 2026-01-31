package com.manu.weathercontrol.core.network

import com.manu.weathercontrol.features.weather.data.datasources.remote.dto.WeatherApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature_2m,relative_humidity_2m,uv_index,wind_speed_10m",
        @Query("hourly") hourly: String = "precipitation_probability",
        @Query("timezone") timezone: String = "auto"
    ): WeatherApiResponse
}
