package com.yash.opttera2.signup.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.Patterns
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
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentSignUpBinding
import com.yash.opttera2.signup.data.remote.PhoneNumberBody
import com.yash.opttera2.signup.data.remote.SignUpEmail
import com.yash.opttera2.signup.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpFragment : Fragment() {


    private val viewModel: SignUpViewModel by viewModels()
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = binding.edtSignUpName.text.toString()
        var email = binding.edtSignUpEmail.text.toString()
        var number = binding.editTextNumber.text.toString()
        val showResponse = binding.apiResponse
        val namePattern = "^[\\p{L} .'-]{2,50}$"
        binding.checkboxRemember1.isEnabled = false
        binding.signUpContinue.isEnabled = false


       fun updateCheckboxState() {
           binding.checkboxRemember1.isEnabled = name.isNotEmpty() && name.matches(namePattern.toRegex()) &&
                   email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
           binding.signUpContinue.isEnabled = binding.checkboxRemember1.isEnabled && binding.checkboxRemember1.isChecked
           binding.signUpContinue.setBackgroundColor(
               if (binding.checkboxRemember1.isEnabled && binding.checkboxRemember1.isChecked) Color.BLUE else Color.GRAY
           )
       }

        binding.edtSignUpName.addTextChangedListener(object :TextWatcher{
            private var debounceJob: Job? = null
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                debounceJob?.cancel()
                name = s.toString()
                // Check if the email format is valid
                if (name.isEmpty() || !name.matches(namePattern.toRegex())) {
               //     showResponse.text = "Please enter a valid Name"
                }else {
                    showResponse.text = ""
                }
                updateCheckboxState()
            }

            override fun afterTextChanged(s: Editable?) {
                debounceJob = lifecycleScope.launch {
                    delay(500)
                    name = s.toString()

                    // Validate the name again after the debounce period
                    if (name.isNotEmpty() && name.matches(namePattern.toRegex())) {
                        // Proceed with further processing if needed
                        showResponse.text = ""
                    } else {
                     //   showResponse.text = "Please enter a valid name"
                    }
                }
                updateCheckboxState()

            }
        })

        binding.edtSignUpEmail.addTextChangedListener(object : TextWatcher {

            private var debounceJob: Job? = null
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                debounceJob?.cancel()
                 email = s.toString()
                // Check if the email format is valid
                if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    showResponse.text = "Please enter a valid email"
                }else{
                    showResponse.text = ""
                }
                updateCheckboxState()
            }
            override fun afterTextChanged(s: Editable?) {
                debounceJob = lifecycleScope.launch {
                    delay(500)
                     email = s.toString()
                    if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        viewModel.emailExist(SignUpEmail(email))
                    }
                }
                updateCheckboxState()
            }
        })

        binding.editTextNumber.addTextChangedListener(object :TextWatcher{
            private var debounceJob: Job? = null
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                number = s.toString()
                // Check if the email format is valid
                if (number.isEmpty() || !Patterns.PHONE.matcher(number).matches()) {
                 //   showResponse.text = "Please enter a valid number"
                }else{
              //      showResponse.text = ""
                }
                updateCheckboxState()
            }

            override fun afterTextChanged(s: Editable?) {

                debounceJob = lifecycleScope.launch {
                    delay(500)
                    number = s.toString()
                    if (number.isNotEmpty() && Patterns.PHONE.matcher(number).matches()) {
                        viewModel.phoneExist(PhoneNumberBody(number))
                    }
                }
                updateCheckboxState()
            }
        })

        binding.checkboxRemember1.setOnCheckedChangeListener { _, isChecked ->
            updateCheckboxState()
        }

        binding.signUpContinue.setOnClickListener {
            if (binding.checkboxRemember1.isChecked) {
                findNavController().navigate(R.id.action_signUp_to_signUpConfirm)
            } else {
                Toast.makeText(requireContext(), "Please check the checkbox to proceed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_logIN)
        }


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.responseSharedFlow1.collect {
                        when (it) {
                            is SignUpViewModel.SignUpEmailEvent.Failure -> {
                                binding.apiResponse.text = it.message
                            }

                            is SignUpViewModel.SignUpEmailEvent.Success -> {
                                binding.apiResponse.text = it.message
                                findNavController().navigate(R.id.action_signUp_to_signUpConfirm)                            }
                            }
                        }
                    }
                }
            }


            val hintName = "  Name *"
            val spannable = SpannableString(hintName)
            val start = spannable.indexOf("*")
            val end = start + "*".length

            spannable.setSpan(
                ForegroundColorSpan(Color.RED),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.edtSignUpName.setHint(spannable)

            val hintEmailId = "  Emaild ID*"
            val spannable1 = SpannableString(hintEmailId)
            val start1 = spannable1.indexOf("*")
            val end1 = start1 + "*".length

            spannable1.setSpan(
                ForegroundColorSpan(Color.RED),
                start1,
                end1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.edtSignUpEmail.setHint(spannable1)



            binding.countyCodePicker1.setOnCountryChangeListener {
                binding.countyCodePicker1.selectedCountryName
                binding.countyCodePicker1.selectedCountryCode
                binding.countyCodePicker1.selectedCountryCodeWithPlus
                binding.countyCodePicker1.selectedCountryFlagResourceId
            }


        }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}





    //                val name = binding.edtSignUpName.text.toString()
//                val email = binding.edtSignUpEmail.text.toString()
//                val phoneNumber = binding.editTextNumber.text.toString()
//                val deviceType = "IOS"
//                val reCaptcha = "token"

    //   viewModel.email = email
//
//                val bundle = Bundle().apply {
//                    putString("name", name)
//                    putString("email", email)
//                    putString("phoneNumber", phoneNumber)
//                    putString("deviceType",deviceType)
//                    putString("reCaptcha",reCaptcha)

