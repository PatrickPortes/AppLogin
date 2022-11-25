package com.example.applogin.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applogin.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var btSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        startingComponents()

        btLogin.setOnClickListener(){
            Toast.makeText(this, "Success Login!!!", Toast.LENGTH_SHORT).show()
        }

        btSignUp.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startingComponents(){
        etEmail = editTextEmailLogin
        etPassword = editTextPasswordLogin
        btLogin = buttonLogin
        btSignUp = textViewSignUp
    }
}

