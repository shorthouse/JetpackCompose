package com.example.jetpackcomposeplayground.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val topicStringId: Int,
    val topicNumber: Int,
    @DrawableRes val imageResourceId: Int
)