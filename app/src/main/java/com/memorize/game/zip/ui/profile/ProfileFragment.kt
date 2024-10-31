package com.memorize.game.zip.ui.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.memorize.game.zip.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListener()

        return root
    }

    private fun initListener() {
        with(binding) {
            iconBack.setOnClickListener {
                findNavController().popBackStack()
            }
            btnLogout.setOnClickListener {
                layoutLoading.isVisible = true
                view?.postDelayed({

                    requireActivity().getSharedPreferences("share_prefs", Context.MODE_PRIVATE)
                        .edit()
                        .putString("username", "")
                        .apply()

                    layoutLoading.isVisible = false
                    Toast.makeText(requireContext(), "Logout in successfully!", Toast.LENGTH_SHORT)
                        .show()
                    findNavController().popBackStack()
                }, 3000L)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val username = requireActivity().getSharedPreferences("share_prefs", Context.MODE_PRIVATE)
            .getString("username", "")

        binding.tvProfile.text = "Wellcome, $username"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}