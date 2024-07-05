package com.yash.opttera2.Profile.Account.MyVehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.Profile.Account.SaveCard.AddCardFragment
import com.yash.opttera2.Profile.Account.SaveCard.SaveCardData
=======
>>>>>>> origin/main
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentMyVehicleBinding


class MyVehicle : Fragment() {

   private lateinit var binding : FragmentMyVehicleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyVehicleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


<<<<<<< HEAD
        val recyclerView: RecyclerView = binding.savedCarRecyclerView
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager


        val saveCarList = listOf(
            CarData(R.drawable.bmw ,"BMW","i3s 94 Ah (2017 - 2018)")
        )

        val adapter = MyVehicleAdapter(saveCarList) { carData ->
            // Handle the click event here
            val addCarDetail = AddCarDetailFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,addCarDetail)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter
=======
>>>>>>> origin/main



    }



<<<<<<< HEAD



=======
>>>>>>> origin/main
}