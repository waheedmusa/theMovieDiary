package com.example.themoviediary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var username: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var string: String
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //Actionbar and its title
        val actionBar = supportActionBar
        actionBar!!.title = null

        button = findViewById(R.id.create_account_btn_signup_page)
        textView = findViewById(R.id.textView)
        textView = findViewById(R.id.email_signup_btn_homepage)


        val button = findViewById<Button>(R.id.create_account_btn_signup_page)
        button.setOnClickListener{

                val intent = Intent(this, DiscoveryActivity::class.java)
                startActivity(intent)

            username = findViewById(R.id.username_edittext_signup_page)
            val username2 =username.text.toString()
            email = findViewById(R.id.email_edittext_signup_page)
            val email2 = email.text.toString()
            password = findViewById(R.id.password_edittext_signup_page)
            val password2 = password.text.toString()

            Log.d("SignUpActivity", "Username is: $username2")
            Log.d("SignUpActivity", "Email is: $email2")
            Log.d("SignUpActivity", "Password is: $password2")

            // Error message if text fields are empty
            if (email2.isEmpty() || password2.isEmpty()) {
                Toast.makeText(this, "Please enter email/pw", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Firebase authentication to create a user with email and password

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email2, password2)
                .addOnCompleteListener{
                    if (!it.isSuccessful) return@addOnCompleteListener

                    // else is successful
                    Log.d("SignUp", "Successfully created user with uid: ${it.result!!.user!!.uid}")
                    Log.d("SignIn", "")
                }
            //On failure
                .addOnFailureListener{
                    Log.d("SignUp", "Failed to create user: ${it.message}")
                    Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
                }



        }

    }
}