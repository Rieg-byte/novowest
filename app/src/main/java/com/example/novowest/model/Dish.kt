package com.example.novowest.model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class Dish(
    val dishId: Int,
    val category: String,
    val nameDish: String,
    val price: Int,
    val image: Int,
    var count: Int = 1
)