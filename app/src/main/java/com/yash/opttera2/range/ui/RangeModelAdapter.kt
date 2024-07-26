package com.yash.opttera2.range.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.R
import com.yash.opttera2.plantrip.ui.ModelAdapter
import com.yash.opttera2.plantrip.ui.ModelDataClass

class RangeModelAdapter(private val rangeCarModelList : List<RangeCarData>,
                        private val itemClickListener: (RangeCarData) -> Unit ) : RecyclerView.Adapter<RangeModelAdapter.MyRangeViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyRangeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.range_model_item, parent, false)
        return MyRangeViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyRangeViewHolder, position: Int) {
        val saveCar = rangeCarModelList[position]
        holder.carDetail.text = saveCar.carDetail
        holder.carName.text = saveCar.carName
        holder.carImage.setImageResource(saveCar.carImage)

        holder.itemView.setOnClickListener {
            itemClickListener(saveCar) // Call the lambda function with the clicked item
        }
    }

    override fun getItemCount(): Int {
        return rangeCarModelList.size    }
    
    class MyRangeViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView)
    {
        val carImage = itemView.findViewById<ImageView>(R.id.imgCar2)
        val carName = itemView.findViewById<TextView>(R.id.txtCarName2)
        val carDetail = itemView.findViewById<TextView>(R.id.txtCarDetail2) 
    }


}