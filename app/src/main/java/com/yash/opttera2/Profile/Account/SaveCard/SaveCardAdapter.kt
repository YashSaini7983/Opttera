package com.yash.opttera2.Profile.Account.SaveCard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yash.opttera2.R

class SaveCardAdapter(
    private val saveCardList : List<SaveCardData>
  ): RecyclerView.Adapter<SaveCardAdapter.SaveCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.save_card_item_detail, parent, false)
        return SaveCardViewHolder(view)
    }

    override fun getItemCount(): Int {
      return   saveCardList.size
    }

    override fun onBindViewHolder(holder: SaveCardViewHolder, position: Int) {
        val saveCard = saveCardList[position]
        holder.cardName.text = saveCard.cardName
        holder.cardexpireDate.text = saveCard.cardExpireDate
        holder.logo.setImageResource(saveCard.logo)


        if(position == 0)
        {
            holder.primarycard.visibility = View.VISIBLE
        }
        else
        {
            holder.primarycard.visibility = View.GONE
        }

    }


    class SaveCardViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)
    {
           val cardName = itemView.findViewById<TextView>(R.id.masterCard)
           val cardexpireDate = itemView.findViewById<TextView>(R.id.expireDate)
           val primarycard = itemView.findViewById<TextView>(R.id.primaryCard)
           val logo = itemView.findViewById<ImageView>(R.id.logo)
    }


}