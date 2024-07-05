package com.yash.opttera2.loginScreen

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentResetPasswordBinding


class ResetPassword : Fragment() {



    private lateinit var  binding: FragmentResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResetPasswordBinding.inflate(inflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // condition of password == confirmPassword


        val hint ="Password*"
        val spannable = SpannableString(hint)

        val start = spannable.indexOf("*")
        val end = start + "*".length

        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtResetPassword.setHint(spannable)


        val hintPassword ="ConfirmPassword*"
        val spannable1 = SpannableString(hintPassword)
        val start1 = spannable1.indexOf("*")
        val end1 = start1 + "*".length

        spannable1.setSpan(
            ForegroundColorSpan(Color.RED),
            start1,
            end1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.edtResetConfirmPassword.setHint(spannable1)








        binding.btnResetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_resetPassword_to_logIN)
        }


    }


}