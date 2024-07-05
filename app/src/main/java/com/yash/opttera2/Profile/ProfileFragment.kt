package com.yash.opttera2.Profile

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yash.opttera2.HomeFragment
import com.yash.opttera2.Profile.Account.MyAccountFragment
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {


    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val  txtOnBoarding = view.findViewById<TextView>(R.id.profile_LogOut)

        val text ="Log Out"
        val spannable  = SpannableString(text)
        val start = spannable.indexOf("Log Out")
        val end  = start + "Log Out".length
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txtOnBoarding.text = spannable


       binding.MyProfile.setOnClickListener {
           val homeFragment = HomeFragment()
           requireActivity().supportFragmentManager.beginTransaction()
               .replace(R.id.drawer_fragment_container, homeFragment)
               .addToBackStack(null)
               .commit()
       }

        binding.MyAccount.setOnClickListener {
            val myAccount = MyAccountFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,myAccount)
                .addToBackStack(null)
                .commit()
        }











<<<<<<< HEAD



=======
>>>>>>> origin/main
    }

}