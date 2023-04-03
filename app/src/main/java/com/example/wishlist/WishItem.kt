package com.example.wishlist
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class WishItem: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wish_item)

        val wishLink: ConstraintLayout = findViewById(R.id.wish_item)
        val linkView = findViewById<TextView>(R.id.urlView)
        val linkText: String = linkView.text.toString()

        linkView.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkText))
                ContextCompat.startActivity(it.context, browserIntent, null)
            }
            catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Invalid URL", Toast.LENGTH_LONG).show()
            }

        }
    }
}