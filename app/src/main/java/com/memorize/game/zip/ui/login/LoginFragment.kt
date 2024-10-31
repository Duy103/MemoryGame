package com.memorize.game.zip.ui.login

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
import com.memorize.game.zip.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListener()

        return root
    }

    private fun initListener() {
        with(binding) {
            tvRegister.setOnClickListener {
                findNavController().navigate(R.id.action_navigaion_login_to_navigaion_register)
            }
            btnLogin.setOnClickListener {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(requireContext(), "Not enough information has been entered", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if (password.length < 6) {
                        Toast.makeText(requireContext(), "Password from 6 characters", Toast.LENGTH_SHORT)
                            .show()
                        return@setOnClickListener
                    }
                    layoutLoading.isVisible = true
                    view?.postDelayed({

                        requireActivity().getSharedPreferences("share_prefs", Context.MODE_PRIVATE)
                            .edit()
                            .putString("username", username)
                            .apply()

                        layoutLoading.isVisible = false
                        Toast.makeText(requireContext(), "Logged in successfully!", Toast.LENGTH_SHORT)
                            .show()
                        findNavController().popBackStack()
                    }, 3000L)
                }
            }
            iconBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}