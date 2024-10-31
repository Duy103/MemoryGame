package com.memorize.game.zip.ui.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.memorize.game.zip.AppConfig
import com.memorize.game.zip.R
import com.memorize.game.zip.databinding.FragmentPlayBinding
import com.memorize.game.zip.model.ConfigGame
import zip.learn.animals.FlipCardView

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private var mode: String = ""

    private lateinit var configGame: ConfigGame
    private var remainingNumberOfClicks: Int = 0
    private var stackCardId: String? = null
    private var stackFlipCard = arrayListOf<FlipCardView>()
    private var flipCardViews = arrayListOf<FlipCardView>()
    private var point = 0
    private var result = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListener()

        mode = arguments?.getString("mode") ?: ""
        if (mode.isEmpty()) {
            findNavController().popBackStack()
            return null
        }

        initData()

        return root
    }

    private fun initListener() {
        with(binding) {
            ivHome.setOnClickListener {
                findNavController().popBackStack()
            }
            btnReplay.setOnClickListener {
                binding.layoutNoti.isVisible = false
                initData()
            }
        }
    }

    private var container: ConstraintLayout? = null

    private fun initData() {
        var level = 1
        remainingNumberOfClicks = 0
        point = 0
        when (mode) {
            "2x2" -> {
                level = 1
                binding.ivMode.setImageResource(R.drawable.mode_2x2)
                container = binding.layoutMode2x2.root
                result = 2
            }

            "3x2" -> {
                level = 2
                binding.ivMode.setImageResource(R.drawable.mode_3x2)
                container = binding.layoutMode3x2.root
                result = 3
            }

            else -> {
                level = 3
                binding.ivMode.setImageResource(R.drawable.mode_4x3)
                container = binding.layoutMode4x3.root
                result = 6
            }

//            "5x4" -> {
//                level = 4
//                binding.ivMode.setImageResource(R.drawable.mode_5x4)
//            }
//
//            "6x5" -> {
//                level = 5
//                binding.ivMode.setImageResource(R.drawable.mode_6x5)
//            }
//
//            "8x7" -> {
//                level = 6
//                binding.ivMode.setImageResource(R.drawable.mode_8x7)
//            }
        }
        configGame = AppConfig.getConfigLevel(level)

        container?.isVisible = true
        with(binding) {
            var count = 0
            tvTaps.text = "$remainingNumberOfClicks"

            container?.children?.let { mCon ->
                mCon.forEach {
                    if (it is FlipCardView) {
                        it.bindLayout(configGame.flipCards[count]) { cardId ->
                            stackFlipCard.add(it)
                            handleCallbackWhenUserTap(cardId)
                        }
                        flipCardViews.add(it)
                        count++
                    }
                }
            }
        }
    }

    private fun handleCallbackWhenUserTap(cardId: String) {
        if (stackCardId.isNullOrEmpty()) {
            stackCardId = cardId
        } else {
            if (stackCardId != cardId) {
                flipCardViews.forEach {
                    it.lock()
                }
                binding.root.postDelayed({
                    stackCardId = null

                    stackFlipCard.forEach {
                        it.hideCard()
                    }
                    stackFlipCard.clear()
                    flipCardViews.forEach {
                        it.unlock()
                    }
                }, 1_500L)
            } else {
                point++
                stackFlipCard.forEach {
                    it.exaclty()
                    it.lock()
                }
                stackFlipCard.clear()
                stackCardId = null
            }
        }
        remainingNumberOfClicks++
        checkAndUpdateUITaps()
    }

    private fun checkAndUpdateUITaps() {
        binding.tvTaps.text = "$remainingNumberOfClicks"
        if (point == result) {
            binding.layoutNoti.isVisible = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}