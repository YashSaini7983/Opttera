package com.yash.opttera2.loginScreen

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
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
import com.yash.opttera2.databinding.FragmentForgotPasswordBinding

private lateinit var binding : FragmentForgotPasswordBinding

class ForgotPassword : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  =  FragmentForgotPasswordBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val hint ="Enter Email/Phone *"
        val spannable = SpannableString(hint)

        val start = spannable.indexOf("*")
        val end = start + "*".length

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtForgotPasswordEmailPhone.setHint(spannable)


       binding.btnSendOTP.setOnClickListener {

           val emailPhone = binding.edtForgotPasswordEmailPhone.text.toString()

           if (emailPhone.isEmpty()) {
               Toast.makeText(requireContext(), "Enter Email or Phone", Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }

           if (!Patterns.EMAIL_ADDRESS.matcher(emailPhone).matches() && !Patterns.PHONE.matcher(emailPhone).matches())
           {
               Toast.makeText(requireContext(), "Enter a valid Email or else Phone", Toast.LENGTH_SHORT)
                   .show()
               return@setOnClickListener
           }

           else
           {
               findNavController().navigate(R.id.action_forgotPassword_to_otpVerification)
           }

        //   showAlert()

           // Delay navigation after showing dialog
           Handler().postDelayed({
               navigateToOtpSendScreen()
           }, 3000)
       }




    }

    private fun showOtpSentDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_box, null)
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialog.show()
    }

    private fun navigateToOtpSendScreen() {
   //     findNavController().navigate(R.id.action_forgotPassword_to_otpSend)
    }

    fun showAlert(context: Context, throwable: Throwable){
        val builder = AlertDialog.Builder(context)
        builder.setMessage(throwable.message).setTitle("Error")
        val dialog = builder.create()
        dialog.show()
    }




}