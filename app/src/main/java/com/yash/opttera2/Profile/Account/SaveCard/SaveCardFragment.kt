package com.yash.opttera2.Profile.Account.SaveCard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentSaveCardBinding

class SaveCardFragment : Fragment() {

    private lateinit var binding : FragmentSaveCardBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSaveCardBinding .inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)







        val recyclerView: RecyclerView = view.findViewById(R.id.savedCardRecyclerView)
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager


        val saveCardList = listOf(
            SaveCardData("Master Card *0011" ,"Expires 05/25", R.drawable.logos_mastercard),
            SaveCardData("Visa Card *0231", "Expires 04/25", R.drawable.logos_visaelectron)

            )

        val adapter = SaveCardAdapter(saveCardList)
        recyclerView.adapter = adapter


        binding.addVechile.setOnClickListener {
            val addCardFragment = AddCardFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,addCardFragment)
                .addToBackStack(null)
                .commit()
        }




    }

}