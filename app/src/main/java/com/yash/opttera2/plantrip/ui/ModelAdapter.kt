package com.yash.opttera2.plantrip.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.yash.opttera2.R

class ModelAdapter(private val carModelList : List<ModelDataClass>,
                   private val itemClickListener: (ModelDataClass) -> Unit ) : RecyclerView.Adapter<ModelAdapter.MyModelViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_plantrip_item, parent, false)
        return MyModelViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyModelViewHolder, position: Int) {
        val saveCar = carModelList[position]
        holder.carDetail.text = saveCar.carDetail
        holder.carName.text = saveCar.carName
        holder.carImage.setImageResource(saveCar.carImage)

        holder.itemView.setOnClickListener {
            itemClickListener(saveCar) // Call the lambda function with the clicked item
        }
    }

    override fun getItemCount(): Int {
        return carModelList.size
    }

    class MyModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage = itemView.findViewById<ImageView>(R.id.imgCar1)
        val carName = itemView.findViewById<TextView>(R.id.txtCarName1)
        val carDetail = itemView.findViewById<TextView>(R.id.txtCarDetail1)
    }



}