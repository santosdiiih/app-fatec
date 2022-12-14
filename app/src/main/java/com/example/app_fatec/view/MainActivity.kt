package com.example.app_fatec.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_fatec.R
import com.example.app_fatec.model.Usuario
import com.example.app_fatec.repository.UsuarioRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertToolbar()
        buttonLogin.setOnClickListener(this)
        buttonCadastro.setOnClickListener(this)
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = getString(R.string.login)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.buttonLogin){
            if(editTextLogin.text.toString() != null || editTextPassword.text.toString() != null){
                verify(editTextLogin.text.toString(), editTextPassword.text.toString())
            }
            else{
                inputTextLogin.isErrorEnabled = true
                inputTextLogin.error = "Digite um email"
            }
        }
        else if(view.id == R.id.buttonCadastro){
            val openCad = Intent(this, NewUser::class.java)
            startActivity(openCad)
        }
    }

    private fun verify(email: String, senha: String){
        var usuario = Usuario()
        val repository = UsuarioRepository(this)
        //usuario = repository.login(email, senha)
        //if(usuario != null){
            val openHome = Intent(this, ScrenChamadosActivity::class.java)
            startActivity(openHome)
       // }
    }
}