package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter (private val wishes: List<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>(){

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Member variables for views that will be set as we render a row, and the view lookups to find each sub-view.
        val nametv: TextView = itemView.findViewById(R.id.nameView)
        val pricetv: TextView = itemView.findViewById(R.id.priceView)
        val urltv: TextView = itemView.findViewById(R.id.urlView)

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wish = wishes.get(position)
        // Set item views based on views and data model
        holder.nametv.text = wish.name
        holder.pricetv.text = wish.price
        holder.urltv.text = wish.url
    }

    override fun getItemCount(): Int {
        return wishes.size
    }

}