package com.manu.weathercontrol.features.weather.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun WeatherInfoItem(
    label: String,
    value: String
) {
    Column {
        Text(text = label)
        Text(text = value)
    }
}
