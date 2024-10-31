package com.memorize.game.zip.ui.levels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.memorize.game.zip.R
import com.memorize.game.zip.databinding.FragmentLevelsBinding

class LevelsFragment : Fragment() {
    private var _binding: FragmentLevelsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentLevelsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListener()

        return root
    }

    private fun initListener() {
        with(binding) {
            ivHome.setOnClickListener {
                findNavController().popBackStack()
            }
            ivMode2x2.setOnClickListener {
                navigationPlayScreen("2x2")
            }
            ivMode3x2.setOnClickListener {
                navigationPlayScreen("3x2")
            }
            ivMode4x3.setOnClickListener {
                navigationPlayScreen("4x3")
            }
            ivMode5x4.setOnClickListener {
                navigationPlayScreen("5x4")
            }
            ivMode6x5.setOnClickListener {
                navigationPlayScreen("6x5")
            }
            ivMode8x7.setOnClickListener {
                navigationPlayScreen("8x7")
            }
        }
    }

    private fun navigationPlayScreen(mode: String) {
        findNavController().navigate(
            R.id.action_navigation_levels_to_navigation_play, bundleOf(
                "mode" to mode
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}