package com.example.applogin.database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ConfiguracaoFirebase {

    private lateinit var referenceDatabase: DatabaseReference
    private lateinit var referenceAuth: FirebaseAuth
    private lateinit var referenceStorage: StorageReference


    fun getUserID(): String{

        val autenticacao: FirebaseAuth = getFirebaseAuth()
        //TODO 1: VERIFICAR NA EXECUÇÃO O VALOR NORMAL E NULL
        //Apenas !! de diferente
        return autenticacao.currentUser!!.uid

    }


    //Retorna Referencia do FirebaseDatabase
    fun getFirebaseDatabase(): DatabaseReference {

        if (referenceDatabase == null){
            referenceDatabase = FirebaseDatabase.getInstance().getReference()
        }
        return referenceDatabase
    }

    //Retorna Referencia do FirebaseAuth
    fun getFirebaseAuth(): FirebaseAuth {

        if (referenceAuth == null){
            referenceAuth = FirebaseAuth.getInstance()
        }
        return referenceAuth
    }

    //Retorna Referencia do FirebaseStorage
    fun getFirebaseStorage(): StorageReference {

        if (referenceStorage == null){
            referenceStorage = FirebaseStorage.getInstance().getReference()
        }
        return referenceStorage
    }


}