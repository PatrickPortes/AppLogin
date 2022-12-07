package com.example.applogin.activity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.applogin.R
import com.example.applogin.database.ConfiguracaoFirebase
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btRegister: Button
    private lateinit var btSignIn: TextView

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //supportActionBar!!.hide()

        startingComponents()

        firebaseAuth = FirebaseAuth.getInstance()

        btRegister.setOnClickListener() {

            val email: String = etEmail.text.toString()
            val senha: String = etPassword.text.toString()

            //Verifica se está vazio
            if (!email.isEmpty()) {
                if (!senha.isEmpty()) {

                    firebaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                        if (it.isSuccessful){

                            Toast.makeText(this, "Cadastro Realizado Com Sucesso!!!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()

                        }else{

                            var erroExcecao = ""

                            try {
                                throw it.exception!!
                            }catch (e: FirebaseAuthWeakPasswordException){
                                erroExcecao = "Digite uma Senha mais Forte!"
                            }catch (e: FirebaseAuthInvalidCredentialsException){
                                erroExcecao = "Digite um Email Válido!"
                            }catch (e: FirebaseAuthUserCollisionException){
                                erroExcecao = "Essa conta ja foi Cadastrada!"
                            }catch (e: Exception){
                                erroExcecao = "ao Cadastrar Usuário: " + e.message
                                e.printStackTrace()
                            }

                            Toast.makeText(this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show()

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
