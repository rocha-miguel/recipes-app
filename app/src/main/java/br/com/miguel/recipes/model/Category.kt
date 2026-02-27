package br.com.miguel.recipes.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import br.com.miguel.recipes.R

data class Category(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val image: Int? = R.drawable.no_photo,
    val background: Color = Color.Gray
)
