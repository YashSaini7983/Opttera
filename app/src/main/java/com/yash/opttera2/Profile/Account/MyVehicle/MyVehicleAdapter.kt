package com.yash.opttera2.Profile.Account.MyVehicle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.Profile.Account.SaveCard.SaveCardAdapter
import com.yash.opttera2.R

class MyVehicleAdapter(
    private val carSavedList : List<CarData> ,
    private val itemClickListener: (CarData) -> Unit ): RecyclerView.Adapter<MyVehicleAdapter.MyVehicleViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myvehicle_card_item, parent, false)
        return MyVehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyVehicleViewHolder, position: Int) {
        val saveCar = carSavedList[position]
        holder.carDetail.text = saveCar.carDetail
        holder.carName.text = saveCar.carName
        holder.carImage.setImageResource(saveCar.carImage)

        holder.itemView.setOnClickListener {
            itemClickListener(saveCar) // Call the lambda function with the clicked item
        }
    }

    override fun getItemCount(): Int {
        return carSavedList.size
    }

    class MyVehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage = itemView.findViewById<ImageView>(R.id.imgCar)
        val carName = itemView.findViewById<TextView>(R.id.txtCarName)
        val carDetail = itemView.findViewById<TextView>(R.id.txtCarDetail)
    }

}



