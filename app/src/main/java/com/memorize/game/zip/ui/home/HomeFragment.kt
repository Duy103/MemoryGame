package com.memorize.game.zip.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.memorize.game.zip.R
import com.memorize.game.zip.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        observeLiveData()
        initListener()

        return root
    }

    private fun observeLiveData() {
        // TODO
    }

    private fun initListener() {
        with(binding) {
            btnQuizGame.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_navigation_levels)
            }
            btnLogin.setOnClickListener {
                val username = requireActivity().getSharedPreferences("share_prefs", Context.MODE_PRIVATE)
                    .getString("username", "")
                if (username.isNullOrEmpty()) {
                    findNavController().navigate(R.id.action_navigation_home_to_navigaion_login)
                } else {
                    findNavController().navigate(R.id.action_navigation_home_to_navigation_profile)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val username = requireActivity().getSharedPreferences("share_prefs", Context.MODE_PRIVATE)
            .getString("username", "")

        if (username.isNullOrEmpty().not()) {
            binding.btnLogin.setImageResource(R.drawable.icon_profile)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}