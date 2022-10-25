package com.example.app_fatec.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app_fatec.R
import com.example.app_fatec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_scren_chamados)

        var email = binding.editTextLogin.text
        var senha = binding.editTextPassword.text

        insertToolbar()
    }

    private fun insertToolbar() {
        //setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = getString(R.string.login) // adiciona o titulo
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // exibe a seta de voltar
    }

    override fun onClick(view: View) {
        binding.buttonLogin.setOnClickListener{
            val openHome = Intent(this, ScrenChamadosActivity::class.java)
            startActivity(openHome)
        }
    }
}