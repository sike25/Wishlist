package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddWIshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_wish)

        // Saving the user inputs into string variables
        val name: String = findViewById<EditText>(R.id.inputName).text.toString()
        val price: String = findViewById<EditText>(R.id.inputPrice).text.toString()
        val url: String = findViewById<EditText>(R.id.inputUrl).text.toString()

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("price", price)
            intent.putExtra("url", url)
            setResult(0, intent)
            this.startActivity(intent)

            //Toast.makeText(this, name+"", Toast.LENGTH_LONG).show()

            finish() // closes the activity, pass data to parent
        }
    }
}