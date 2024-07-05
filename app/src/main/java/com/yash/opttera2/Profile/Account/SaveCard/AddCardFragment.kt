package com.yash.opttera2.Profile.Account.SaveCard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentAddCardBinding
import com.yash.opttera2.databinding.FragmentSaveCardBinding


class AddCardFragment : Fragment() {

    private lateinit var binding: FragmentAddCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddCardBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.addCardHeader.setOnClickListener {
            val saveCardFragment = SaveCardFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container,saveCardFragment)
                .addToBackStack(null)
                .commit()
        }



    }

}