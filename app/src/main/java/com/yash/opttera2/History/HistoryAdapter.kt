package com.yash.opttera2.History

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.Profile.Account.MyVehicle.CarData
import com.yash.opttera2.Profile.Account.MyVehicle.MyVehicleAdapter
import com.yash.opttera2.R

class HistoryAdapter(
    private val historyList : List<HistoryData> ,
    private val itemClickListener: (HistoryData) -> Unit
    ): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> () {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myvehicle_card_item, parent, false)
        return HistoryAdapter.HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
      return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
       val history = historyList[position]
       holder.destinationDetail.text = history.location
        holder.amount.text = history.amount
        holder.distance.text = history.distance
        holder.dateTime.text = history.dateTime


        holder.itemView.setOnClickListener {
            itemClickListener(history) // Call the lambda function with the clicked item
        }
    }


    class HistoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val destinationDetail = itemView.findViewById<TextView>(R.id.txtLocationDestination)
        val dateTime = itemView.findViewById<TextView>(R.id.txt_Date)
        val amount = itemView.findViewById<TextView>(R.id.txt_amount)
        val distance = itemView.findViewById<TextView>(R.id.txt_distance)
    }



}