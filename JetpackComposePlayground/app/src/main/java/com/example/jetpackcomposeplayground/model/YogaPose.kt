package com.example.jetpackcomposeplayground.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class YogaPose (
    @StringRes val nameRes: Int,
    @StringRes val instructionRes: Int,
    @DrawableRes val imageRes: Int
)