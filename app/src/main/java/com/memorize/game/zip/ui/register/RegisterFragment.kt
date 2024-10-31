package com.memorize.game.zip.ui.register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.memorize.game.zip.R
import com.memorize.game.zip.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListener()

        return root
    }

    private fun initListener() {
        with(binding) {
            iconBack.setOnClickListener {
                findNavController().popBackStack()
            }
            btnRegister.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()
                val csPassword = edtConfirmPassword.text.toString()

                if (username.isEmpty() || password.isEmpty() || csPassword.isEmpty()) {
                    Toast.makeText(requireContext(), "Not enough information has been entered", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if (password.length < 6) {
                        Toast.makeText(requireContext(), "Password from 6 characters", Toast.LENGTH_SHORT)
                            .show()
                    } else if (password != csPassword) {
                        Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        layoutLoading.isVisible = true
                        view?.postDelayed({

                            requireActivity().getSharedPreferences("share_prefs", Context.MODE_PRIVATE)
                                .edit()
                                .putString("username", username)
                                .apply()

                            layoutLoading.isVisible = false
                            Toast.makeText(requireContext(), "Register successfully!", Toast.LENGTH_SHORT)
                                .show()
                            findNavController().navigate(R.id.action_navigaion_register_to_navigation_home)
                        }, 3000L)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}