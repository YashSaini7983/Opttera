package com.yash.opttera2.signup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yash.opttera2.R

class LoginVehicleModelAdapter(
    private val onItemClick :(LoginVehicleModelData)->(Unit)
): ListAdapter<LoginVehicleModelData,LoginVehicleModelAdapter.ModelViewHolder>(UserDiffCallBack()) {


    private var selectedItem: LoginVehicleModelData?= null

    // DiffUtil.Callback implementation for efficient updates
    class UserDiffCallBack : DiffUtil.ItemCallback<LoginVehicleModelData>() {
        override fun areItemsTheSame(
            oldItem: LoginVehicleModelData,
            newItem: LoginVehicleModelData
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: LoginVehicleModelData,
            newItem: LoginVehicleModelData
        ): Boolean = oldItem == newItem
    }

    class ModelViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val modelImage : ImageView = itemView.findViewById(R.id.img_BrandImage)
        val modelVersion: TextView = itemView.findViewById(R.id.txt_ModelVersion)
        val modelBrand : TextView = itemView.findViewById(R.id.txt_ModelBrand)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.model_list_item, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = getItem(position)

        // Update the item view based on selection state
     //  holder.itemView.visibility = if (model == selectedItem) View.GONE else View.VISIBLE
        holder.modelVersion.text = model.modelVersion
        holder.modelBrand.text = model.modelBrand
        Glide.with(holder.itemView.context)
            .load(model.image)  // model.image is a URL
            .into(holder.modelImage)

        holder.itemView.setOnClickListener {
            // Set the selected item and notify changes
            selectedItem = model
            notifyDataSetChanged() // Notify that data has changed
            onItemClick(model)
        }    }

    fun setSelectedItem(item: LoginVehicleModelData?) {
        selectedItem = item
        notifyDataSetChanged() // Notify that data has changed
    }


}