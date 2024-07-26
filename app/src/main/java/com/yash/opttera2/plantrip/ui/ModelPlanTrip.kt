package com.yash.opttera2.plantrip.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.Profile.Account.MyVehicle.AddCarDetailFragment
import com.yash.opttera2.Profile.Account.MyVehicle.CarData
import com.yash.opttera2.Profile.Account.MyVehicle.MyVehicleAdapter
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentModelPlanTripBinding
import com.yash.opttera2.databinding.FragmentPlanTripBinding

class ModelPlanTrip : Fragment() {

    private var _binding: FragmentModelPlanTripBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentModelPlanTripBinding .inflate(inflater,container,false)
        return binding.root    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.modelRecyclerView
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        val saveCarList = listOf(
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),
            ModelDataClass(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)"),

        )

        val adapter = ModelAdapter(saveCarList) { modelData ->
             //Handle the click event here
              val addModel = FinalPlantrip()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.planTripContainer,addModel)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter

//
//        binding.btnPlanTrip1.setOnClickListener {
//            val addModel = FinalPlantrip()
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.planTripContainer,addModel)
//                .addToBackStack(null)
//                .commit()
//        }










    }


    override fun onDestroyView() {
        _binding =null
        super.onDestroyView()

    }


}