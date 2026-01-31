package com.manu.weathercontrol.features.weather.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.manu.weathercontrol.features.weather.presentation.components.CenterMessage
import com.manu.weathercontrol.features.weather.presentation.viewmodels.WeatherViewModel

@Composable
fun WeatherOverviewScreen(
    viewModel: WeatherViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> {
            CenterMessage("Cargando clima...")
        }

        uiState.weather == null -> {
            CenterMessage("No hay datos de clima")
        }

        else -> {
            val weather = uiState.weather ?: return

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                // Título
                Text(
                    text = "Clima actual",
                    style = MaterialTheme.typography.headlineLarge
                )

                // Temperatura PRINCIPAL
                Text(
                    text = "${weather.temperature}°C",
                    style = MaterialTheme.typography.displayLarge
                )

                // Info secundaria
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Humedad: ${weather.humidity} %",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Viento: ${weather.windSpeed} km/h",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Índice UV: ${weather.uvIndex}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Prob. de lluvia: ${weather.rainProbability} %",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
