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
import com.yash.opttera2.databinding.FragmentRangeModelBinding
import com.yash.opttera2.plantrip.ui.ModelAdapter
import com.yash.opttera2.plantrip.ui.ModelDataClass
import com.yash.opttera2.plantrip.ui.ModelPlanTrip


class RangeModel : Fragment() {

    private var _binding : FragmentRangeModelBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRangeModelBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.rangeRecyclerView
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        val saveCarList = listOf(
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            RangeCarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),


            )



        val adapter = RangeModelAdapter(saveCarList) { modelData ->
            //Handle the click event here
               val finalRange = FinalRange()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.rangeContainer, finalRange)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter


//        binding.btnCalculate.setOnClickListener {
//            val finalRange = FinalRange()
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.rangeContainer, finalRange)
//                .addToBackStack(null)
//                .commit()
//        }
    }



    override fun onDestroyView() {
        _binding =null
        super.onDestroyView()

    }



}