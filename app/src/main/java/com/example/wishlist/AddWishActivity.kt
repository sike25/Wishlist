package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddWishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_wish)

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            // Saving the user inputs into string variables
            val name: String = findViewById<EditText>(R.id.inputName).text.toString()
            val price: String = findViewById<EditText>(R.id.inputPrice).text.toString()
            val url: String = findViewById<EditText>(R.id.inputUrl).text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("price", price)
            intent.putExtra("url", url)
            setResult(RESULT_OK, intent)

            //this.startActivity(intent)
            finish() // closes the activity, pass data to parent
        }
    }
}