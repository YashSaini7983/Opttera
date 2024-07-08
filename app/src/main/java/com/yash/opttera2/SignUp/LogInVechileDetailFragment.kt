package com.yash.opttera2.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.yash.opttera2.R
import com.yash.opttera2.databinding.FragmentLogInVechileDetailBinding

class LogInVechileDetailFragment : Fragment() {

    private lateinit var binding: FragmentLogInVechileDetailBinding
    private lateinit var vehicleBrandSpinner: Spinner
    private lateinit var vehicleModelSpinner: Spinner
    private lateinit var brandAdapter: ArrayAdapter<String>
    private lateinit var modelAdapter: ArrayAdapter<String>
    private lateinit var selectedCarImageView: ImageView
    private lateinit var txtSelectedCarName: TextView
    private lateinit var txtSelectedCarDetail: TextView

    private val brandItems = listOf("Select Vehicle Brand", "BMW", "Chevrolet", "Lamborghini", "Cadillac")
    private val modelItems = listOf("Select Vehicle Model", "i3s 94 Ah (2017 - 2018)", "i3s 94 Ah (2015 - 2017)", "iX xDrive50")
    private val carImages = mapOf("BMW" to R.drawable.car)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInVechileDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedCarImageView = binding.imgSelectedImage
        txtSelectedCarName = binding.txtSelectedCarName
        txtSelectedCarDetail = binding.txtSelectedCarDetail

        vehicleBrandSpinner = binding.spinnerVehicleBrand
        vehicleModelSpinner = binding.spinnerVehicleModel

        // Set up the brand Spinner
        brandAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item, brandItems)
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        vehicleBrandSpinner.adapter = brandAdapter

        // Set up the model Spinner
        modelAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item, modelItems)
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        vehicleModelSpinner.adapter = modelAdapter

        // Optionally set the hint to be displayed initially
        vehicleBrandSpinner.setSelection(0, false)
        vehicleModelSpinner.setSelection(0, false)

        // Handle item selection for brand Spinner
        vehicleBrandSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position > 0) {
                    val selectedBrand = brandItems[position]
                    val selectedImage = carImages[selectedBrand] ?: R.drawable.no_vehicle_background
                    selectedCarImageView.setImageResource(selectedImage)
                    txtSelectedCarName.text = selectedBrand
                    txtSelectedCarDetail.text = "Model: ${vehicleModelSpinner.selectedItem}"
                    enableSaveButtonIfBothSelected()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Not implemented
            }
        }

        // Handle item selection for model Spinner
        vehicleModelSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position > 0) {
                    txtSelectedCarDetail.text = "Model: ${modelItems[position]}"
                    enableSaveButtonIfBothSelected()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Not implemented
            }
        }

        // Initially disable the save button
        binding.saveVehicle.isEnabled = false

        // Navigate to HomeFragment when Save Vehicle button is clicked
        binding.saveVehicle.setOnClickListener {
            findNavController().navigate(R.id.action_logInVechileDetailFragment_to_homeFragment)
        }
        binding.saveVehicle.setOnClickListener {
            findNavController().navigate(R.id.action_logInVechileDetailFragment_to_homeFragment)
        }
    }

    private fun enableSaveButtonIfBothSelected() {
        val brandPosition = vehicleBrandSpinner.selectedItemPosition
        val modelPosition = vehicleModelSpinner.selectedItemPosition
        binding.saveVehicle.isEnabled = brandPosition > 0 && modelPosition > 0
    }
}
