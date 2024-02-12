package com.umc.coumo.presentation.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.umc.coumo.R
import com.umc.coumo.databinding.FragmentLoginBinding
import com.umc.coumo.domain.viewmodel.LoginViewModel
import com.umc.coumo.presentation.activity.MainActivity
import com.umc.coumo.utils.binding.BindingFragment

class LoginFragment : BindingFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnLogin.setOnClickListener {
            val loginId: String = binding.textboxLoginId.text.toString()
            val password: String = binding.textboxLoginPassword.text.toString()
            viewModel.postLogin(loginId, password) //TODO(임시 코드)
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUp1Fragment)
        }

        binding.btnFindId.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("selected_btn", "find_id")

            findNavController().navigate(R.id.action_loginFragment_to_phoneVerificationFragment, bundle)
        }

        binding.btnFindPw.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("selected_btn", "find_pw")

            findNavController().navigate(R.id.action_loginFragment_to_phoneVerificationFragment, bundle)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        findNavController().popBackStack()
    }
}