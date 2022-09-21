package com.example.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//https://us.dolcegabbana.com/en/fashion/women/bags/medium-sicily-bag-in-polished-calfskin-black-BB7117A103780999.html?cgid=women-bags
//https://www.apple.com/shop/buy-iphone/iphone-14-pro

class MainActivity : AppCompatActivity() {
    //init list of wishes
    private var wishes: MutableList<Wish> = mutableListOf()
    //alternative syntax: var wishes = mutableListOf<Wish>()

    private lateinit var wishListRv: RecyclerView
    private lateinit var adapter: WishAdapter
    private lateinit var addWishButton: Button
    private lateinit var item: TextView

    private lateinit var name: String
    private lateinit var price: String
    private lateinit var url: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the recyclerview in activity layout
        wishListRv = findViewById<View>(R.id.recyclerView) as RecyclerView
        wishes.add(Wish("Dolce Bag", "$2541", "https://us.dolcegabbana.com/en/fashion/women/bags/medium-sicily-bag-in-polished-calfskin-black-BB7117A103780999.html?cgid=women-bags"))
        wishes.add(Wish("iPhone 14 Pro", "$1000", "https://www.apple.com/shop/"))
        wishes.add(Wish("Indomie Noodles", "$40", "https://www.osiafrik.com/"))
        wishes.add(Wish("HBOMax Subscription", "$12", "https://www.hbomax.com/"))
        wishes.add(Wish("Campbells' Biology", "$97", "https://www.abebooks.com/"))
        wishes.add(Wish("stuff", "1", "some store"))


        // Create adapter passing in the sample user data
        adapter = WishAdapter(wishes)
        // Attach the adapter to the recyclerview to populate items
        wishListRv.adapter = adapter
        // Set layout manager to position the items
        wishListRv.layoutManager = LinearLayoutManager(this)

        item = findViewById(R.id.textView)
        item.setOnClickListener{

            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://us.dolcegabbana.com/en/fashion/women/bags/medium-sicily-bag-in-polished-calfskin-black-BB7117A103780999.html?cgid=women-bags"))
                ContextCompat.startActivity(it.context, browserIntent, null)
            }
            catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Invalid URL for Dolce Bag", Toast.LENGTH_LONG).show()
            }
        }

        addWishButton = findViewById(R.id.addWishButton)
        addWishButton.setOnClickListener {
            // first parameter is the context, second is the class of the activity to launch
             val i = Intent(this, AddWIshActivity::class.java)
            startActivityForResult(i, 0) // brings up the second activity

            val newItem = Wish("Sleeping bag", "$20", "https://amazon.com")
            wishes.add(newItem)
            adapter.notifyDataSetChanged()

        }
    }

    @Deprecated("")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val newItem = Wish("Sleeping bag", "$20", "https://amazon.com")
        wishes.add(newItem)
        adapter.notifyDataSetChanged()


        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this, "sexy", Toast.LENGTH_LONG).show()

        if (data != null) {
            Toast.makeText(this, "sexy", Toast.LENGTH_LONG).show()

            if (requestCode == 0) { // this 0 needs to match the 0 we used when we called startActivityForResult!
                Toast.makeText(this, "sexier", Toast.LENGTH_LONG).show()

                name = data.extras!!.getString("name").toString()
                price = data.extras!!.getString("price").toString()
                url = data.extras!!.getString("url").toString()

                val newItem = Wish(name, price, url)
                wishes.add(newItem)
                adapter.notifyDataSetChanged()
            }
        }
    }
//
//
//
//    var editActivityResultLauncher: ActivityResultLauncher<Intent> =
//        registerForActivityResult( ActivityResultContracts.StartActivityForResult() )
//            { result ->
//            }




}