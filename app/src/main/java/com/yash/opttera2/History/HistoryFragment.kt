package com.yash.opttera2.History

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.Profile.Account.MyVehicle.AddCarDetailFragment
import com.yash.opttera2.Profile.Account.MyVehicle.MyVehicleAdapter
import com.yash.opttera2.Profile.Account.SaveCard.SaveCardAdapter
import com.yash.opttera2.Profile.Account.SaveCard.SaveCardData
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = binding.historyRecyclerView
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager


        val historyList = listOf(
            HistoryData("230 KM","$545","Amterdam to Delft","23/05/2023, 8:30 PM",R.drawable.carbon_location)
        )


        val adapter = HistoryAdapter(historyList) { historydata ->
            // Handle the click event her
    //       findNavController().navigate(R.id.action_historyFragment_to_historyTripDetails)
        //  findNavController().navigate(R.id.action_homeFragment_to_historyTripDetails)


//            val tripHistoryDetail = HistoryTripDetails()
//                requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.drawer_fragment_container,tripHistoryDetail)
//                .addToBackStack(null)
//                .commit()



             requireParentFragment().requireParentFragment().findNavController().navigate(R.id.action_homeFragment_to_historyTripDetails)
        }

        recyclerView.adapter = adapter


    }
}