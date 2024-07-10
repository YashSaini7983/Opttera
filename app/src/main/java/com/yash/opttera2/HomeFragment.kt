package com.yash.opttera2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.yash.opttera2.Profile.ProfileFragment
import com.yash.opttera2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navView: NavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val toolbar = binding.toolbar
        val drawerLayout = binding.drawerLayout
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



        toolbar.setNavigationOnClickListener {
            val profileFragment = ProfileFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_fragment_container, profileFragment)
                .addToBackStack(null)
                .commit()
        }
          val navHostFragment = childFragmentManager.findFragmentById(R.id.home_navHost) as NavHostFragment
          binding.bottomNavigation.setupWithNavController(navHostFragment.navController)



    }


}

