package com.yash.opttera2.Profile.Account.Refreral

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yash.opttera2.Profile.ProfileFragment
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentRefrealfragmentBinding


class Refrealfragment : Fragment() {

     private lateinit var binding: FragmentRefrealfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRefrealfragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.ReferralHeader.setOnClickListener {
            val profileFragment = ProfileFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container, profileFragment)
                .addToBackStack(null)
                .commit()
        }



    }


}