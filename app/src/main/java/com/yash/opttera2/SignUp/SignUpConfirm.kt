package com.yash.opttera2.SignUp

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentSignUpConfirmBinding

class SignUpConfirm : Fragment() {

    private lateinit var binding : FragmentSignUpConfirmBinding
    private var isPasswordVisible = false // Initialize the variable here


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpConfirmBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val hintName ="Password*"
        val spannable = SpannableString(hintName)
        val start = spannable.indexOf("*")
        val end = start+"*".length

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtSignUpPassword.setHint(spannable)


        val hintName1 ="ConfirmPassword*"
        val spannable1 = SpannableString(hintName1)
        val start1 = spannable1.indexOf("*")
        val end1 = start1+"*".length

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
            val password = binding.edtSignUpPassword.text.toString()
            val confirmPassword = binding.edtSignUpConfirmPassword.text.toString()


            if(password.isEmpty() && confirmPassword.isEmpty())
            {
                Toast.makeText(requireContext(),"Fill the Detail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(password.isEmpty())
            {
                Toast.makeText(requireContext(),"Enter the Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (confirmPassword.isEmpty())
            {
                Toast.makeText(requireContext(),"Enter the Confirm Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(password.equals(confirmPassword))
            {
                //  findNavController().navigate()
            }
        }

        binding.arrowBack.setOnClickListener {
            findNavController().navigate(R.id.action_signUpConfirm_to_signUp)
        }

        binding.edtSignUpPassword.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // Check if the touch is within the drawable area
                if (event.rawX >= (binding.edtSignUpPassword.right - binding.edtSignUpPassword.compoundDrawables[2].bounds.width())) {
                    // Toggle the password visibility flag
                    isPasswordVisible = !isPasswordVisible

                    // Update the input type and drawable icon based on the flag
                    if (isPasswordVisible) {
                        binding.edtSignUpPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        binding.edtSignUpPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.eye, 0)
                    } else {
                        binding.edtSignUpPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        binding.edtSignUpPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.eye, 0)
                    }

                    // Move the cursor to the end of the text
                    binding.edtSignUpPassword.setSelection(binding.edtSignUpPassword.text.length)
                    return@setOnTouchListener true
                }
            }
            false
        }


        binding.edtSignUpConfirmPassword.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // Check if the touch is within the drawable area
                if (event.rawX >= (  binding.edtSignUpConfirmPassword.right -   binding.edtSignUpConfirmPassword.compoundDrawables[2].bounds.width())) {
                    // Toggle the password visibility flag
                    isPasswordVisible = !isPasswordVisible

                    // Update the input type and drawable icon based on the flag
                    if (isPasswordVisible) {
                        binding.edtSignUpPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        binding.edtSignUpPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.eye, 0)
                    } else {
                        binding.edtSignUpConfirmPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        binding.edtSignUpConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                            R.drawable.eye, 0)
                    }

                    // Move the cursor to the end of the text
                    binding.edtSignUpConfirmPassword.setSelection(  binding.edtSignUpConfirmPassword.text.length)
                    return@setOnTouchListener true
                }
            }
            false
        }






    }




}

