package com.example.jetpackcomposeplayground.data

import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.model.Superhero
import com.example.jetpackcomposeplayground.model.Topic

object SuperheroDataSource {
    val heroes = listOf(
        Superhero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.hero_description1,
            imageRes = R.drawable.android_superhero1
        ),
        Superhero(
            nameRes = R.string.hero2,
            descriptionRes = R.string.hero_description2,
            imageRes = R.drawable.android_superhero2
        ),
        Superhero(
            nameRes = R.string.hero3,
            descriptionRes = R.string.hero_description3,
            imageRes = R.drawable.android_superhero3
        ),
        Superhero(
            nameRes = R.string.hero4,
            descriptionRes = R.string.hero_description4,
            imageRes = R.drawable.android_superhero4
        ),
        Superhero(
            nameRes = R.string.hero5,
            descriptionRes = R.string.hero_description5,
            imageRes = R.drawable.android_superhero5
        ),
        Superhero(
            nameRes = R.string.hero6,
            descriptionRes = R.string.hero_description6,
            imageRes = R.drawable.android_superhero6
        )
    )
}
