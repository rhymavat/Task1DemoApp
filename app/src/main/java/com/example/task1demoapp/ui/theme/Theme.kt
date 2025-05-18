package com.example.task1demoapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define a light color scheme for the app
private val LightColors = lightColorScheme(
    primary = Color(0xFF3F51B5),     // Indigo
    onPrimary = Color.White,
    secondary = Color(0xFF2196F3),   // Blue
    onSecondary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
)

// The theme wrapper for your app's UI
@Composable
fun Task1DemoAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
