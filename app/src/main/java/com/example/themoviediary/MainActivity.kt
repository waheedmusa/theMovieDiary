package com.example.themoviediary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
//    late init var altSignIn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.email_signup_btn_homepage)
        button.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val altSignIn = findViewById<TextView>(R.id.signin_link_homepage)

        altSignIn.setOnClickListener {
            Log.d("MainActivity", "Show Login Info")

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }



    }
}




