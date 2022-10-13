package com.example.app_fatec

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        insertToolbar()
    }

    @SuppressLint("ResourceType")
    private fun insertToolbar() {
        supportActionBar!!.title = getString(R.string.login) // adiciona o titulo
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // exibe a seta de voltar
    }

    override fun onClick(view: View) {

    }


}