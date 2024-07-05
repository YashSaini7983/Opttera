package com.yash.opttera2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.journeyapps.barcodescanner.BarcodeEncoder
import org.w3c.dom.Text

class CardAdapter(private val cardList: List<Card>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>(){




    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val holderName: TextView = itemView.findViewById(R.id.holder_name)
        val cardNumber: TextView = itemView.findViewById(R.id.card_number)
        val issueDate: TextView = itemView.findViewById(R.id.issue_date)
        val barcode: ImageView = itemView.findViewById(R.id.barcode)
        val cardView: CardView = itemView.findViewById(R.id.card_view) // Add reference to CardView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.holderName.text = card.holderName
        holder.cardNumber.text = card.cardNumber
        holder.issueDate.text = card.issueDate
        holder.cardView.setCardBackgroundColor(card.backgroundColor)

        // Generate barcode
        val barcodeEncoder = BarcodeEncoder()
        val bitmap = barcodeEncoder.encodeBitmap(card.barcodeData, com.google.zxing.BarcodeFormat.CODE_128, 600, 300)
        holder.barcode.setImageBitmap(bitmap)
    }


}


