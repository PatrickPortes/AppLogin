package com.example.applogin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.applogin.R
import com.example.applogin.database.ConfiguracaoFirebase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btRegister: Button
    private lateinit var btSignIn: TextView

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.hide()

        startingComponents()

        btRegister.setOnClickListener() {

            val email: String = etEmail.text.toString()
            val senha: String = etPassword.text.toString()

            //Verifica se está vazio
            if (!email.isEmpty()) {
                if (!senha.isEmpty()) {

                    auth.createUserWithEmailAndPassword(
                        email, senha
                    ).addOnCompleteListener { task ->
                        if (task.isSuccessful){

                            Toast.makeText(this, "Cadastro Realizado Com Sucesso!!!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this, "Erro ao Fazer o Cadastro!!!", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    Toast.makeText(this, "Preencha a Senha!!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha o Email!!!", Toast.LENGTH_SHORT).show()
            }
        }

        btSignIn.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startingComponents() {
        etEmail = editTextEmailRegister
        etPassword = editTextPasswordRegister
        btRegister = buttonRegister
        btSignIn = textViewSignIn
    }
}
