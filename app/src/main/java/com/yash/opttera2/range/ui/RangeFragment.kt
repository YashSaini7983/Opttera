package com.yash.opttera2.range.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentPlanTripBinding
import com.yash.opttera2.databinding.FragmentRangeBinding
import com.yash.opttera2.plantrip.ui.ModelAdapter
import com.yash.opttera2.plantrip.ui.ModelDataClass
import com.yash.opttera2.plantrip.ui.ModelPlanTrip


class RangeFragment : Fragment() {

    private var _binding : FragmentRangeBinding? =  null
    private val binding get() = _binding!!
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRangeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.rangeAddVehicle.setOnClickListener {
            val rangeCarDetail = RangeModel()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.rangeContainer, rangeCarDetail)
                .addToBackStack(null)
                .commit()
        }
        
    }

    override fun onDestroyView() {
        _binding =null
        super.onDestroyView()

    }

}