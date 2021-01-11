package com.example.themoviediary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    lateinit var signinEmail: EditText
    lateinit var signinPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //Actionbar and its title
        val actionBar = supportActionBar
        actionBar!!.title = null

        val button = findViewById<Button>(R.id.signin_btn)
        button.setOnClickListener {

            val intent = Intent(this, DiscoveryActivity::class.java)
            startActivity(intent)

            signinEmail = findViewById(R.id.email_edittext_signin_page)
            val signinEmail2 = signinEmail.text.toString()
            signinPassword = findViewById(R.id.password_edittext_signin_page)
            val signinPassword2 = signinPassword.text.toString()



            Log.d("SignInActivity", "Email is: $signinEmail2")
            Log.d("SignInActivity", "Password is: $signinPassword2")

            // Error message if text fields are empty
            if (signinEmail2.isEmpty() || signinPassword2.isEmpty()) {
                Toast.makeText(this, "Please enter email/pw", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(signinEmail2, signinPassword2)
                .addOnCompleteListener{
                    if (!it.isSuccessful) return@addOnCompleteListener

                    // else is successful
                    Log.d("SignIn", "Successfully created user with uid: ${it.result!!.user!!.uid}")
                }
        }


    }
}