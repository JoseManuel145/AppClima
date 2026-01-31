package com.manu.weathercontrol.features.weather.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Clima : TabItem("clima", "Clima", Icons.Default.Build)
    object Ropa : TabItem("ropa", "Ropa", Icons.Default.Build)
    object Comida : TabItem("comida", "Comida", Icons.Default.Build)
    object Actividad : TabItem("actividad", "Actividad", Icons.Default.Build)
    object Seguridad : TabItem("seguridad", "Seguridad", Icons.Default.Build)
}
