package com.example.jetpackcomposeplayground.data

import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.model.Affirmation

class AffirmationDataSource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.affirmation_1),
            Affirmation(R.string.affirmation2, R.drawable.affirmation_2),
            Affirmation(R.string.affirmation3, R.drawable.affirmation_3),
            Affirmation(R.string.affirmation4, R.drawable.affirmation_4),
            Affirmation(R.string.affirmation5, R.drawable.affirmation_5),
            Affirmation(R.string.affirmation6, R.drawable.affirmation_6),
            Affirmation(R.string.affirmation7, R.drawable.affirmation_7),
            Affirmation(R.string.affirmation8, R.drawable.affirmation_8),
            Affirmation(R.string.affirmation9, R.drawable.affirmation_9),
            Affirmation(R.string.affirmation10, R.drawable.affirmation_10))
    }
}
