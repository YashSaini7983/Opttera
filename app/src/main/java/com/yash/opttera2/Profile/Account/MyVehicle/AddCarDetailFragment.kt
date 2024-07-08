package com.yash.opttera2.Profile.Account.MyVehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentAddCarDetailBinding


class AddCarDetailFragment : Fragment() {


    private lateinit var binding : FragmentAddCarDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddCarDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.addCardHeader.setOnClickListener {
            val myVehicle = MyVehicle()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,myVehicle)
                .addToBackStack(null)
                .commit()
        }

    }

}