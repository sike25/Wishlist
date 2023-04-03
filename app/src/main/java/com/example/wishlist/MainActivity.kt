package com.example.wishlist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var wishes: MutableList<Wish>
    private lateinit var newItem: Wish
    private lateinit var adapter: WishAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Look up RecyclerView on activity layout
        val wishesRv = findViewById<RecyclerView>(R.id.WishRV)
        //Fetch list of wishes
        wishes = WishFetcher.getWishes()
        //Create adapter to the RecyclerView to populate items
        adapter = WishAdapter(wishes)
        //Attach the adapter to the RecyclerView to populate items
        wishesRv.adapter = adapter
        //Set layout manager to position the items
        wishesRv.layoutManager = LinearLayoutManager(this)

        val addWishButton: Button = findViewById(R.id.addWishButton)
        addWishButton.setOnClickListener {
            // first parameter is the context, second is the class of the activity to launch
            val i = Intent(this, AddWishActivity::class.java)
            startActivityForResult(i, 0) // brings up the second activity
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    @Deprecated("")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (requestCode == 0) { // this 0 needs to match the 0 we used when we called startActivityForResult!
                val name = data.extras!!.getString("name").toString()
                val price = data.extras!!.getString("price").toString()
                val url = data.extras!!.getString("url").toString()

                newItem = Wish(name, price, url)
                wishes.add(newItem)
                adapter.notifyDataSetChanged()
            }
        }
    }
}