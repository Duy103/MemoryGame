package com.memorize.game.zip

import android.util.Log
import com.memorize.game.zip.model.ConfigGame
import zip.learn.animals.CardModel
import java.util.Collections
import kotlin.random.Random

object AppConfig {

    fun level1(random: Int): List<CardModel> {
        if (random % 4 == 0) {
            return listOf(
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002)
            )
        } else if (random % 4 == 1) {
            return listOf(
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003)
            )
        } else return listOf(
            CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
            CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
            CardModel("card_004", R.drawable.front_res, R.drawable.ani_004),
            CardModel("card_004", R.drawable.front_res, R.drawable.ani_004)
        )
    }

    fun level2(random: Int): List<CardModel> {
        if (random % 4 == 0) {
            return listOf(
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
            )
        } else if (random % 4 == 1) {
            return listOf(
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_004", R.drawable.front_res, R.drawable.ani_004),
                CardModel("card_004", R.drawable.front_res, R.drawable.ani_004)
            )
        } else if (random % 4 == 2) {
            return listOf(
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_004", R.drawable.front_res, R.drawable.ani_004),
                CardModel("card_004", R.drawable.front_res, R.drawable.ani_004)
            )
        } else return listOf(
            CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
            CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
            CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
            CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
            CardModel("card_004", R.drawable.front_res, R.drawable.ani_004),
            CardModel("card_004", R.drawable.front_res, R.drawable.ani_004)
        )
    }

    fun level3(random: Int): List<CardModel> {
        if (random % 3 == 0)
            return listOf(
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_004", R.drawable.front_res, R.drawable.ani_004),
                CardModel("card_004", R.drawable.front_res, R.drawable.ani_004),
                CardModel("card_005", R.drawable.front_res, R.drawable.ani_005),
                CardModel("card_005", R.drawable.front_res, R.drawable.ani_005),
                CardModel("card_006", R.drawable.front_res, R.drawable.ani_006),
                CardModel("card_006", R.drawable.front_res, R.drawable.ani_006)
            )
        if (random % 3 == 1)
            return listOf(
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_002", R.drawable.front_res, R.drawable.ani_002),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
                CardModel("card_005", R.drawable.front_res, R.drawable.ani_005),
                CardModel("card_005", R.drawable.front_res, R.drawable.ani_005),
                CardModel("card_006", R.drawable.front_res, R.drawable.ani_006),
                CardModel("card_006", R.drawable.front_res, R.drawable.ani_006),
                CardModel("card_007", R.drawable.front_res, R.drawable.ani_007),
                CardModel("card_007", R.drawable.front_res, R.drawable.ani_007),
            )
        return listOf(
            CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
            CardModel("card_001", R.drawable.front_res, R.drawable.ani_001),
            CardModel("card_007", R.drawable.front_res, R.drawable.ani_007),
            CardModel("card_007", R.drawable.front_res, R.drawable.ani_007),
            CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
            CardModel("card_003", R.drawable.front_res, R.drawable.ani_003),
            CardModel("card_005", R.drawable.front_res, R.drawable.ani_005),
            CardModel("card_005", R.drawable.front_res, R.drawable.ani_005),
            CardModel("card_006", R.drawable.front_res, R.drawable.ani_006),
            CardModel("card_006", R.drawable.front_res, R.drawable.ani_006),
            CardModel("card_008", R.drawable.front_res, R.drawable.ani_008),
            CardModel("card_008", R.drawable.front_res, R.drawable.ani_008),
        )
    }

    fun getConfigLevel(level: Int): ConfigGame {
        Log.d("ZEUS", "getConfigLevel $level")
        val random = Random.nextInt(10)
        if (level == 1) {
            val list = level1(random)
            Collections.shuffle(list)
            return ConfigGame(level, 2, 6, list)
        }
        if (level == 2) {
            val list = level2(random)
            Collections.shuffle(list)
            return ConfigGame(level, 3, 16, list)
        }
        if (level == 3) {
            val list = level3(random)
            Collections.shuffle(list)
            return ConfigGame(level, 3, 20, list)
        }
//        if (level == 4) {
//            val list = level4(random)
//            Collections.shuffle(list)
//            return ConfigGame(level, 4, 20, list)
//        }
//        if (level == 5) {
//            val list = level4(random)
//            Collections.shuffle(list)
//            return ConfigGame(level, 4, 18, list)
//        }
        return ConfigGame(1, 2, 6, listOf())
    }
}