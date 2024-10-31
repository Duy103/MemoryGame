package com.memorize.game.zip.model

import zip.learn.animals.CardModel

data class ConfigGame(
    val level: Int, val point: Int, val maxTaps: Int, val flipCards: List<CardModel>
)