package com.example.novowest.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController



private val DarkColorPalette = darkColors(
    primary = BlueDark800, //кнопки
    onPrimary = White,//текст на кнопках
    surface = Grey900,
    background = Grey900,
    primaryVariant = Dark,
    secondary = Amber800,
    error = Color.Red
)

private val LightColorPalette = lightColors(
    primary = BlueDark800,
    onPrimary = White,
    surface = Grey100,
    onSurface = Dark,
    background = White,
    primaryVariant = Dark,
    secondary = Amber800,
    error = Color.Red

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)


@Composable
fun NovoWestTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content
    )
    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = Color.White
        )
    }
}