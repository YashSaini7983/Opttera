package com.yash.opttera2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.yash.opttera2.Profile.ProfileFragment
import com.yash.opttera2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

     private lateinit var binding : FragmentHomeBinding
    private lateinit var navView: NavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val toolbar = binding.toolbar
        val drawerLayout = binding.drawerLayout
        val navigationView = binding.navigationView
        val headerView = navigationView.getHeaderView(0)
        val headerTitle = headerView.findViewById<TextView>(R.id.header_title)







        (activity as? AppCompatActivity)?.let {
            it.setSupportActionBar(toolbar)
            val toggle = ActionBarDrawerToggle(
                it, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
        }
            drawerLayout.closeDrawers()
            true

/**

        headerView.setOnClickListener {
            headerTitle.text = getString(R.string.main_header_title) // Set to your main header title
            navigationView.menu.clear()
            navigationView.inflateMenu(R.menu.nav_menu) // Set to your main menu resource
        }



        navigationView.setNavigationItemSelectedListener {
                menuItem ->
            // Handle navigation view item clicks here.
            when (menuItem.itemId) {
                R.id.nav_myAccount -> {
                    // Replace the header with "My Account"
                    headerTitle.text = "My Account"
                    navigationView.menu.clear()
                    navigationView.inflateMenu(R.menu.nav_menu_myaccount)
                    true
                }
                R.id.nav_personaldetail -> {
                    // Replace the current fragment with the PersonalDetail fragment
                    val personalDetailFragment = PersonalDetail()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, personalDetailFragment)
                        .addToBackStack(null)
                        .commit()
                    true

                }
                R.id.nav_referral->
                {
                    val referralFragment  = Refrealfragment()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, referralFragment)
                        .addToBackStack(null)
                        .commit()
                    true

                }
                R.id.nav_loyaltyCards->
                {
                    val loyaltyCardFragment  = LoyaltyCard()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, loyaltyCardFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.nav_HelpCentre -> {
                    // Handle Help Centre click
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.privacyPolicy -> {
                    // Handle Privacy Policy click
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_logout -> {
                    // Handle Log Out click
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> false
            }
        }

        **/

        toolbar.setNavigationOnClickListener {
            val profileFragment = ProfileFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container, profileFragment)
                .addToBackStack(null)
                .commit()
        }







    }





}

