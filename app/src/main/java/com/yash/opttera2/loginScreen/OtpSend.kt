package com.yash.opttera2.loginScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentOtpSendBinding


class OtpSend : Fragment() {

    private lateinit var binding: FragmentOtpSendBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentOtpSendBinding.inflate(inflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val registerEmailPhone = arguments?.getString("registerEmailPhone")

        // Show the OTP sent dialog
        showOtpSentDialog(registerEmailPhone)
    }


    private fun showOtpSentDialog(registerEmailPhone: String?) {
        // Inflate the dialog layout
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.fragment_otp_send, null)

        // Find the TextView in the dialog layout and set the message
  //      val messageTextView: TextView = dialogView.findViewById(R.id.txt_otp_sent_message)
  //      val message = "An OTP has been sent to your registered email/phone: $registerEmailPhone"
  //      messageTextView.text = message

        // Build the dialog
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogView)
            .setPositiveButton("OK") { _, _ -> }

        // Show the dialog
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}