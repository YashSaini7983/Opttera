package com.yash.opttera2.History

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.tabs.TabLayout
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentHistoryBinding
import com.yash.opttera2.databinding.FragmentHistoryTripDetailsBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HistoryTripDetails : Fragment() {

  private val viewModel: HistoryTripDetailViewModel by viewModels()
    private  var _binding : FragmentHistoryTripDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryTripDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the state flow and update the UI accordingly

       viewLifecycleOwner.lifecycleScope.launch {
           repeatOnLifecycle(Lifecycle.State.STARTED){
               launch {
                   viewModel.tabData.collectLatest {
                       binding.txtAmsterdam.text = it.currentRoute
                   }
               }
           }

       }





        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        // Update data for Tab 1
                        viewModel.updateTab1Data()
                    }
                    1 -> {
                        // Update data for Tab 2
                        viewModel.updateTab2Data()
                    }
                    2 -> {
                        // Update data for Tab 3
                        viewModel.updateTab3Data()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        _binding =null
        super.onDestroyView()
    }




}