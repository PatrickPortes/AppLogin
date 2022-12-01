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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var btSignUp: TextView

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        startingComponents()

        firebaseAuth = FirebaseAuth.getInstance()

        //firebaseAuth.signOut()

        verificaUsuarioLogado()

        //LOGIN:
        btLogin.setOnClickListener(){

            val email: String = etEmail.text.toString()
            val senha: String = etPassword.text.toString()

            //Diferenças para RegisterActivity= isNotEmpty e task ->

            //Verifica se está vazio
            if( email.isNotEmpty()){
                if( senha.isNotEmpty()){

                    firebaseAuth.signInWithEmailAndPassword(
                        email, senha
                    ).addOnCompleteListener { task ->
                        if (task.isSuccessful){

                            Toast.makeText(this, "Login Realizado Com Sucesso!!!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)

                        }else{

                            Toast.makeText(this, "Erro ao Fazer Login, Senha ou Email Inválido!!! ", Toast.LENGTH_SHORT).show()

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

    private fun verificaUsuarioLogado() {
        val usuarioAtual: FirebaseUser = firebaseAuth.currentUser
        if (usuarioAtual != null){

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun startingComponents(){
        etEmail = editTextEmailLogin
        etPassword = editTextPasswordLogin
        btLogin = buttonLogin
        btSignUp = textViewSignUp
    }
}

