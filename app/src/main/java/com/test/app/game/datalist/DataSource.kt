package com.test.app.game.datalist

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.test.app.game.R

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class DataSource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation_1, R.drawable.image1),
            Affirmation(R.string.affirmation_2, R.drawable.image2),
            Affirmation(R.string.affirmation_3, R.drawable.image3),
            Affirmation(R.string.affirmation_4, R.drawable.image4),
            Affirmation(R.string.affirmation_5, R.drawable.image5),
            Affirmation(R.string.affirmation_6, R.drawable.image6),
            Affirmation(R.string.affirmation_7, R.drawable.image7),
            Affirmation(R.string.affirmation_8, R.drawable.image8),
            Affirmation(R.string.affirmation_9, R.drawable.image9),
            Affirmation(R.string.affirmation_10, R.drawable.image10)
        )
    }
}

data class Topic(
    @StringRes val stringRes: Int,
    val availableCourses: Int,
    @DrawableRes val imageRes: Int
)

object DataTopic {
    val topics = listOf(
        Topic(R.string.affirmation_1, 100, R.drawable.image1),
        Topic(R.string.affirmation_2, 200, R.drawable.image2),
        Topic(R.string.affirmation_3, 300, R.drawable.image3),
        Topic(R.string.affirmation_4, 400, R.drawable.image4),
        Topic(R.string.affirmation_5, 500, R.drawable.image5),
        Topic(R.string.affirmation_6, 600, R.drawable.image6),
        Topic(R.string.affirmation_7, 700, R.drawable.image7),
        Topic(R.string.affirmation_8, 800, R.drawable.image8),
        Topic(R.string.affirmation_9, 900, R.drawable.image9),
        Topic(R.string.affirmation_10, 999, R.drawable.image10)
    )
}