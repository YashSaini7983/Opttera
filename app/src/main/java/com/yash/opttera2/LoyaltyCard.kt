package com.yash.opttera2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.databinding.FragmentLogINBinding
import com.yash.opttera2.databinding.FragmentLoyaltyCardBinding


class LoyaltyCard : Fragment() {

    private lateinit var binding : FragmentLoyaltyCardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        binding = FragmentLoyaltyCardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager


        val cardList = listOf(
            Card("VAHAB ROSTAPOUR", "3482 8384 8283 ****", "24/08/23", "KLM227C13806", Color.BLUE),
            Card("VAHAB ROSTAPOUR", "3482 8384 8283 ****", "24/08/23", "KLM227C13806",Color.GREEN),

        )

        val adapter = CardAdapter(cardList)
        recyclerView.adapter = adapter



    }


}