package com.example.jetpackcomposeplayground.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Superhero (
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)