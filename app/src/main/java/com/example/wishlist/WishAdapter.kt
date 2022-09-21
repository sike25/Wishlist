package com.example.wishlist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WishAdapter (private val mWishes: List<Wish>) :
//mWishes is my list of wishes
    RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nametv: TextView = itemView.findViewById(R.id.nametv)
        val pricetv: TextView = itemView.findViewById(R.id.pricetv)
        val urltv: TextView = itemView.findViewById(R.id.urltv)

    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: WishAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val wishItem: Wish = mWishes[position]
        //or val wish: Wish = mWishes.get(position)

        // Set item views based on your views and data model
        val name = viewHolder.nametv
        name.setText(wishItem.name)

        //or alternative, more succinct syntax-- a lesson here
        viewHolder.pricetv.text = wishItem.price
        viewHolder.urltv.text = wishItem.url
    }

    override fun getItemCount(): Int {
        return mWishes.size
    }
}