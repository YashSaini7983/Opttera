package com.yash.opttera2.signup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.R


// Adapter for displaying vehicle brands in a RecyclerView
class LoginVehicleAdapter(
    private val onItemClick: (LoginVehicleData) -> Unit
) : ListAdapter<LoginVehicleData, LoginVehicleAdapter.BrandHolder>(UserDiffCallBack()) {

    private var selectedItem: LoginVehicleData? = null

    // DiffUtil.Callback implementation for efficient updates
    class UserDiffCallBack : DiffUtil.ItemCallback<LoginVehicleData>() {
        override fun areItemsTheSame(
            oldItem: LoginVehicleData,
            newItem: LoginVehicleData
        ): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: LoginVehicleData,
            newItem: LoginVehicleData
        ): Boolean = oldItem == newItem
    }

    // ViewHolder for each item in the RecyclerView
    class BrandHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandNameVehicle: TextView = itemView.findViewById(R.id.brandName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brand_list_item, parent, false)
        return BrandHolder(view)
    }

    override fun onBindViewHolder(holder: BrandHolder, position: Int) {
        val brand = getItem(position)

        // Update the item view based on selection state
        holder.itemView.visibility = if (brand == selectedItem) View.GONE else View.VISIBLE
        holder.brandNameVehicle.text = brand.name

        holder.itemView.setOnClickListener {
            // Set the selected item and notify changes
            selectedItem = brand
            notifyDataSetChanged() // Notify that data has changed
            onItemClick(brand)
        }
    }

    // Function to set the selected item
    fun setSelectedItem(item: LoginVehicleData?) {
        selectedItem = item
        notifyDataSetChanged() // Notify that data has changed
    }
}
