package com.yash.opttera2.loginScreen

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentLogINBinding


class LogIN : Fragment() {

    private lateinit var binding : FragmentLogINBinding
    private var isPasswordVisible = false // Initialize the variable here


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLogINBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hint = "  Enter Email/Phone *"
        val spannable = SpannableString(hint)

        val start = spannable.indexOf("*")
        val end = start + "*".length

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtLogInEmailPhone.setHint(spannable)


        val hintPassword = "  Password *"
        val spannable1 = SpannableString(hintPassword)
        val start1 = spannable1.indexOf("*")
        val end1 = start1 + "*".length

        spannable1.setSpan(
            ForegroundColorSpan(Color.RED),
            start1,
            end1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtLogInPassword.setHint(spannable1)


        binding.txtSignup.setOnClickListener {
           findNavController().navigate(R.id.action_logIN_to_signUp)
        }

        binding.txtLogINForgotPassword.setOnClickListener {
           findNavController().navigate(R.id.action_logIN_to_forgotPassword)
        }
        Log.d("TAG", "Method Started")
        binding.btnLogIn.setOnClickListener {


            val emailPhone = binding.edtLogInEmailPhone.text.toString()
            val password = binding.edtLogInPassword.text.toString()


            //  Log.d("TAG", "Email/Phone: $emailPhone")
            //  Log.d("TAG", "Password: $password")
            // Log.d("TAG", "Method Ended")

            if(emailPhone.isEmpty() && password.isEmpty())
            {
                Toast.makeText(requireContext(), "Fill the detail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (emailPhone.isEmpty()) {
                Toast.makeText(requireContext(), "Enter Email or Phone", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(emailPhone).matches() && !Patterns.PHONE.matcher(
                    emailPhone
                ).matches()
            ) {
                Toast.makeText(requireContext(), "Enter a valid Email or else Phone", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(requireContext(), "Enter the Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                     findNavController().navigate(R.id.action_logIN_to_homeFragment)
            }



        }



        binding.edtLogInPassword.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // Check if the touch is within the drawable area
                if (event.rawX >= (binding.edtLogInPassword.right - binding.edtLogInPassword.compoundDrawables[2].bounds.width())) {
                    // Toggle the password visibility flag
                    isPasswordVisible = !isPasswordVisible

                    // Update the input type and drawable icon based on the flag
                    if (isPasswordVisible) {
                        binding.edtLogInPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        binding.edtLogInPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.eye, 0)
                    } else {
                        binding.edtLogInPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        binding.edtLogInPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.eye, 0)
                    }

                    // Move the cursor to the end of the text
                    binding.edtLogInPassword.setSelection(binding.edtLogInPassword.text.length)
                    return@setOnTouchListener true
                }
            }
            false
        }



    }




}