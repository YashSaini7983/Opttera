package com.yash.opttera2.Profile.Account.Persondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentPersonalDetailBinding


private lateinit var binding : FragmentPersonalDetailBinding

class PersonalDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonalDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       binding.edtBasicDetail.setOnClickListener {

           val basicDetail = BasicDetail()
               requireActivity().supportFragmentManager.beginTransaction()
               .replace(R.id.drawer_fragment_container,basicDetail)
               .addToBackStack(null)
               .commit()

       }


     binding.edtLogindetails.setOnClickListener {

         val changePassword = ChangePassword()
         requireActivity().supportFragmentManager.beginTransaction()
             .replace(R.id.drawer_fragment_container,changePassword)
             .addToBackStack(null)
             .commit()

     }





    }






}