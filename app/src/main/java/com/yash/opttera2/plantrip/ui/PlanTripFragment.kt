package com.yash.opttera2.plantrip.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.Profile.Account.MyVehicle.AddCarDetailFragment
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentPlanTripBinding


class PlanTripFragment : Fragment() {



    private var _binding: FragmentPlanTripBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlanTripBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.planTripAddVehicle.setOnClickListener {
            val addCarDetail = ModelPlanTrip()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.planTripContainer, addCarDetail)
                .addToBackStack(null)
                .commit()
        }
    }


    override fun onDestroyView() {
        _binding =null
        super.onDestroyView()

    }

}