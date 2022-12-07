package com.example.applogin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.applogin.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //supportActionBar!!.hide()

        firebaseAuth = FirebaseAuth.getInstance()

        //Configurações ToolBar:
        toolbar = toolbarMain
        toolbar.setTitle("Home Screen")
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_logout, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menuLogout -> deslogarUsuario()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deslogarUsuario() {

        firebaseAuth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}