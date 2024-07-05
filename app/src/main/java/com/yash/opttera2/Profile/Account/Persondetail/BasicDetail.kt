package com.yash.opttera2.Profile.Account.Persondetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentBasicDetailBinding


class BasicDetail : Fragment() {

    private lateinit var binding: FragmentBasicDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBasicDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSave.setOnClickListener {
            val personalDetail = PersonalDetail()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,personalDetail)
                .addToBackStack(null)
                .commit()

        }

        binding.BasicDetails.setOnClickListener {
            val personalDetail = PersonalDetail()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,personalDetail)
                .addToBackStack(null)
                .commit()
        }







    }

}