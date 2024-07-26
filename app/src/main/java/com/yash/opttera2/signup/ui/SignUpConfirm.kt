package com.yash.opttera2.signup.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentSignUpConfirmBinding
import com.yash.opttera2.signup.data.remote.SignUpBody
import com.yash.opttera2.signup.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpConfirm : Fragment() {

    private val viewModel: SignUpViewModel by viewModels()
    private var _binding: FragmentSignUpConfirmBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpConfirmBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val edtPasswordL = view.findViewById<TextInputLayout>(R.id.edt_SignUp_Password)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.edt_SignUp_Password1)


        edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                edtPasswordL.error = null // Clear the error message
                validatePassword(edtPassword, edtPasswordL)
                edtPasswordL.errorIconDrawable = null
                checkPasswordMatch()
            }

        })

        val edtConfirmPasswordL =
            view.findViewById<TextInputLayout>(R.id.edt_SignUp_ConfirmPassword)
        val edtConfirmPassword =
            view.findViewById<TextInputEditText>(R.id.edt_SignUp_ConfirmPassword1)

        edtConfirmPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                validateConfirmPassword(edtPassword, edtConfirmPassword, edtConfirmPasswordL)
                edtConfirmPasswordL.errorIconDrawable = null
                checkPasswordMatch()
            }
        })

//        val name = arguments?.getString("name") ?: ""
//        val email = arguments?.getString("email") ?: ""
//        val phoneNumber = arguments?.getString("phoneNumber") ?: ""

        val hintName = "Password*"
        val spannable = SpannableString(hintName)
        val start = spannable.indexOf("*")
        val end = start + "*".length

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtSignUpPassword.setHint(spannable)


        val hintName1 = "ConfirmPassword*"
        val spannable1 = SpannableString(hintName1)
        val start1 = spannable1.indexOf("*")
        val end1 = start1 + "*".length

        spannable1.setSpan(
            ForegroundColorSpan(Color.RED),
            start1,
            end1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtSignUpConfirmPassword.setHint(spannable1)


        binding.txtLogIN.setOnClickListener {
            findNavController().navigate(R.id.action_signUpConfirm_to_logIN)
        }

        binding.btnSignUpConfirm.setOnClickListener {
            viewModel.signUP(SignUpBody(confirmPassword ="", email = "", name = "", password = "", phoneNumber = "", deviceType ="IOS","token"))
            findNavController().navigate(R.id.action_signUpConfirm_to_logInVechileDetailFragment)

        }

        binding.arrowBack.setOnClickListener {
            findNavController().navigate(R.id.action_signUpConfirm_to_signUp)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.responseSharedFlow.collect {
                        when (it) {
                            is SignUpViewModel.SignUpEvent.ShowToast -> {
                                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                            is SignUpViewModel.SignUpEvent.Success -> {
                                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                                    .show()
                                findNavController().navigate(R.id.action_signUpConfirm_to_logInVechileDetailFragment)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun checkPasswordMatch() {
        val password = binding.edtSignUpPassword1.text.toString().trim()
        val confirmPassword = binding.edtSignUpConfirmPassword1.text.toString().trim()

        if (password == confirmPassword) {
            binding.btnSignUpConfirm.isEnabled = true
            binding.btnSignUpConfirm.setBackgroundColor(Color.BLUE)
        } else {
            binding.btnSignUpConfirm.isEnabled = false
            binding.btnSignUpConfirm.setBackgroundColor(Color.GRAY)
        }
    }

    private fun validateConfirmPassword(
        edtPassword: TextInputEditText,
        edtConfirmPassword: TextInputEditText,
        edtConfirmPasswordL: TextInputLayout
    ): Boolean {
        return when {

            edtPassword.text.toString().trim() != edtConfirmPassword.text.toString().trim() -> {
                edtConfirmPasswordL.error = "Password Did not match"
                false
            }

            else -> {
                edtConfirmPasswordL.error = null
                true
            }
        }
    }

    private fun validatePassword(
        edtPassword: TextInputEditText,
        edtPasswordL: TextInputLayout
    ): Boolean {
        val password = edtPassword.text.toString().trim()

        if (password.isEmpty()) {
            return true
        }

        if (password.contains(" ")) {
            if (password.split(" ").size > 1) {
                edtPasswordL.error = "Password should not contain spaces"
                edtPasswordL.setErrorTextColor(ColorStateList.valueOf(Color.RED)) // Set error text color to red

                return false
            }
        }
        if (password.length < 8) { // Assuming you want a minimum password length of 8
            edtPasswordL.error = "Password must be at least 8 characters "
            edtPasswordL.setErrorTextColor(ColorStateList.valueOf(Color.RED)) // Set error text color to red

            return false
        }
        if (!password.matches(".*[A-Z].*".toRegex())) {
            edtPasswordL.error = "Password must contain at least one uppercase letter"
            edtPasswordL.setErrorTextColor(ColorStateList.valueOf(Color.RED)) // Set error text color to red

            return false
        }
        if (!password.matches(".*[a-z].*".toRegex())) {
            edtPasswordL.error = "Password must contain at least one lowercase letter"
            edtPasswordL.setErrorTextColor(ColorStateList.valueOf(Color.RED)) // Set error text color to red

            return false
        }
        if (!password.matches(".*\\d.*".toRegex())) {
            edtPasswordL.error = "Password must contain at least one digit"
            edtPasswordL.setErrorTextColor(ColorStateList.valueOf(Color.RED)) // Set error text color to red

            return false
        }
        if (!password.matches(".*[!@#\$%^&*(),.?\":{}|<>].*".toRegex())) {
            edtPasswordL.error = "Password must contain at least one special character"
            edtPasswordL.setErrorTextColor(ColorStateList.valueOf(Color.RED)) // Set error text color to red

            return false
        }
        return true
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}





