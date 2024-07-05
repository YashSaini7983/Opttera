package com.yash.opttera2.SignUp

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentSignUpBinding

private lateinit var binding : FragmentSignUpBinding

class SignUp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.txtLogIN.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_logIN)
        }




        val hintName ="  Name *"
        val spannable = SpannableString(hintName)
        val start = spannable.indexOf("*")
        val end = start+"*".length

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtSignUpName.setHint(spannable)

        val  hintEmailId ="  Emaild ID*"
        val spannable1 = SpannableString(hintEmailId)
        val start1 = spannable1.indexOf("*")
        val end1 = start1+"*".length

        spannable1.setSpan(
            ForegroundColorSpan(Color.RED),
            start1,
            end1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtSignUpEmail.setHint(spannable1)



        binding.countyCodePicker.setOnCountryChangeListener {
            binding.countyCodePicker.selectedCountryName
            binding.countyCodePicker.selectedCountryCode
            binding.countyCodePicker.selectedCountryCodeWithPlus
            binding.countyCodePicker.selectedCountryFlagResourceId
        }


        binding.signUpContinue.setOnClickListener {

            val name = binding.edtSignUpName.text.toString()
            val email = binding.edtSignUpEmail.text.toString()

            if(name.isEmpty() && email.isEmpty())
            {
                Toast.makeText(requireContext(),"Fill the Detail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(name.isEmpty())
            {
                Toast.makeText(requireContext(),"Enter the Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(email.isEmpty())
            {
                Toast.makeText(requireContext(),"Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                Toast.makeText(requireContext(),"Fill CorrectEmail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else
            {
                findNavController().navigate(R.id.action_signUp_to_signUpConfirm)

            }

        }




    }








}