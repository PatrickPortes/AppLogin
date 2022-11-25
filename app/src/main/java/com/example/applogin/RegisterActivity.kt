package com.example.applogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btRegister: Button
    private lateinit var btSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.hide()

        startingComponents()

        btRegister.setOnClickListener(){
            Toast.makeText(this, "Success Register!!!", Toast.LENGTH_SHORT).show()
        }

        btSignIn.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startingComponents(){
        etEmail = editTextEmailRegister
        etPassword = editTextPasswordRegister
        btRegister = buttonRegister
        btSignIn = textViewSignIn
    }
}