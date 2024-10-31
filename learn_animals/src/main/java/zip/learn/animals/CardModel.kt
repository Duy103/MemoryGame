package zip.learn.animals

import androidx.annotation.DrawableRes

data class CardModel(
    val cardId: String,
    @DrawableRes val frontId: Int,
    @DrawableRes val backsideId: Int
)