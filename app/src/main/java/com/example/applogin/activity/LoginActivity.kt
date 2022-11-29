package com.example.applogin.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applogin.R
import com.example.applogin.database.ConfiguracaoFirebase
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var btSignUp: TextView

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        startingComponents()


        //LOGIN:
        btLogin.setOnClickListener(){

            val email: String = etEmail.text.toString()
            val senha: String = etPassword.text.toString()

            //Verifica se está vazio
            if( !email.isEmpty()){
                if( !senha.isEmpty()){

                    auth.signInWithEmailAndPassword(
                        email, senha
                    ).addOnCompleteListener { task ->
                        if (task.isSuccessful){

                            Toast.makeText(this, "Login Realizado Com Sucesso!!!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)

                        }else{

                            Toast.makeText(this, "Erro ao Fazer o Login!!!", Toast.LENGTH_SHORT).show()

                        }
                }

                }else{
                    Toast.makeText(this, "Preencha a Senha!!!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Preencha o Email!!!", Toast.LENGTH_SHORT).show()
            }

        }

        //REGISTER SCREEN:
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

