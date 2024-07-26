package com.yash.opttera2.signup.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentLogInVechileDetailBinding
import com.yash.opttera2.signup.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LogInVechileDetailFragment : Fragment() {

    private var _binding: FragmentLogInVechileDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var adapter: LoginVehicleAdapter
    private lateinit var modelAdapter: LoginVehicleModelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogInVechileDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LoginVehicleAdapter { selectedItem ->
            // Update EditText with the selected item name
            binding.searchBrand.setText(selectedItem.name)
            //  hide the RecyclerView when an item is selected
            binding.brandRecyclerView.visibility = View.GONE
            Glide.with(binding.imgSelectedImage.context)
                .load(selectedItem.imageUrl)
                .into(binding.imgSelectedImage)
            // Notify the adapter about the selected item
            adapter.setSelectedItem(selectedItem)
        }

        modelAdapter = LoginVehicleModelAdapter { selectedItem ->
            // Update EditText with the selected item name
            binding.searchModel.setText(selectedItem.modelVersion)
            //  hide the RecyclerView when an item is selected
            binding.modelVersionRecyclerView.visibility = View.GONE
            // Notify the adapter about the selected item
            modelAdapter.setSelectedItem(selectedItem)
        }

        binding.modelVersionRecyclerView.adapter = modelAdapter
        binding.modelVersionRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.brandRecyclerView.adapter = adapter
        binding.brandRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.searchBrand.addTextChangedListener(object : TextWatcher {
            private var debounceJob: Job? = null

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.searchQuery(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

                if (s.isNullOrEmpty()) {
                    binding.brandRecyclerView.visibility = View.VISIBLE
                }
            }
        })

        binding.searchModel.setOnClickListener {
            val searchEditBox = binding.searchModel.text.toString()
            if (searchEditBox.isEmpty()) {
                viewModel.fetchVehicleModel("", 1, 10, binding.searchBrand.text.toString())
                binding.modelVersionRecyclerView.visibility = View.VISIBLE
            }
        }

        binding.searchBrand.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.brandRecyclerView.visibility = View.VISIBLE
            } else {
                binding.brandRecyclerView.visibility = View.GONE
            }
        }

        binding.searchModel.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                            binding.modelVersionRecyclerView.visibility = View.VISIBLE
            } else {
                            binding.modelVersionRecyclerView.visibility = View.GONE
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.spinnerItem.collect { spinnerItem ->
                    if (spinnerItem.isNotEmpty() && spinnerItem != null) {
                        val names = spinnerItem.map { LoginVehicleData(it.name, it.url) }
                        adapter.submitList(names)
                        binding.brandRecyclerView.visibility = View.VISIBLE
                    } else {
                        binding.brandRecyclerView.visibility = View.GONE
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.spinnerBrand.collect { spinnerItem ->
                    if (spinnerItem.isNotEmpty() && spinnerItem != null) {
                        val names =
                            spinnerItem.map { LoginVehicleModelData(it.url, it.version, it.model) }
                        modelAdapter.submitList(names)
                        binding.modelVersionRecyclerView.visibility = View.VISIBLE
                    } else {
                        binding.modelVersionRecyclerView.visibility = View.GONE
                    }
                }
            }
        }
        // Navigate to HomeFragment when Save Vehicle button is clicked
        binding.saveVehicle.setOnClickListener {
            findNavController().navigate(R.id.action_logInVechileDetailFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}