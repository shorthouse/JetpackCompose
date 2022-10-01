package com.example.jetpackcomposeplayground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

//private val DarkColorPaletteWoofApp = darkColors(
//    background = Cyan900,
//    surface = Cyan700,
//    onSurface = White,
//    primary = Grey900,
//    onPrimary = White,
//    secondary = Grey100
//)
//
//
//private val LightColorPaletteWoofApp = lightColors(
//    background = Green100,
//    surface = Green50,
//    onSurface = Grey900,
//    primary = Grey100,
//    onPrimary = Grey900,
//    secondary = Grey700
//)
//
private val DarkColorPalette = darkColors(
    background = md_theme_dark_background,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary
)
//
//private val LightColorPalette = lightColors(
//    background = md_theme_light_background,
//    surface = md_theme_light_surface,
//    onSurface = md_theme_light_onSurface,
//    primary = md_theme_light_primary,
//    onPrimary = md_theme_light_onPrimary,
//    secondary = md_theme_light_secondary
//)

private val LightColorPalette = lightColors(
    primary = yoga_primary,
    primaryVariant = yoga_primary_dark,
    secondary = yoga_secondary,
    secondaryVariant = yoga_secondary_dark,
    onPrimary = yoga_on_primary,
    onSecondary = yoga_on_secondary,
    surface = yoga_primary_light,
)


@Composable
fun JetpackComposePlaygroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}