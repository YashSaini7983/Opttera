package com.yash.opttera2.Profile.Account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import com.yash.opttera2.Profile.Account.MyVehicle.MyVehicle
=======
>>>>>>> origin/main
import com.yash.opttera2.Profile.Account.Persondetail.PersonalDetail
import com.yash.opttera2.Profile.ProfileFragment
import com.yash.opttera2.R
import com.yash.opttera2.Profile.Account.SaveCard.SaveCardFragment
import com.yash.opttera2.Profile.Account.Refreral.Refrealfragment
import com.yash.opttera2.databinding.FragmentMyAccountBinding


class MyAccountFragment : Fragment() {

    private lateinit var binding : FragmentMyAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.MyAccountHeader.setOnClickListener {
            val profileFragment = ProfileFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,profileFragment)
                .addToBackStack(null)
                .commit()
        }


        binding.personalDetails.setOnClickListener {
            val personalDetail = PersonalDetail()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,personalDetail)
                .addToBackStack(null)
                .commit()
        }


        binding.savedCard.setOnClickListener {
            val saveCard = SaveCardFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,saveCard)
                .addToBackStack(null)
                .commit()
        }

        binding.referral.setOnClickListener {
            val refreral = Refrealfragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,refreral)
                .addToBackStack(null)
                .commit()
        }

<<<<<<< HEAD
        binding.vechileDetails.setOnClickListener {
            val MyVehicleDetails = MyVehicle()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,MyVehicleDetails)
                .addToBackStack(null)
                .commit()
        }
=======
>>>>>>> origin/main



    }


}