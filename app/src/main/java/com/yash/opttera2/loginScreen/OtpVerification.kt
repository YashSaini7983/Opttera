package com.yash.opttera2.loginScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentOtpVerificationBinding


class OtpVerification : Fragment() {

    private lateinit var binding : FragmentOtpVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOtpVerificationBinding.inflate(inflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSendOTP.setOnClickListener {
            findNavController().navigate(R.id.action_otpVerification_to_resetPassword)
        }


    }




}