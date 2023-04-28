package com.example.app_fatec.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app_fatec.R
import com.example.app_fatec.model.Chamado
import com.example.app_fatec.repository.ChamadoRepository
import kotlinx.android.synthetic.main.activity_detalhes_chamado.*
import kotlinx.android.synthetic.main.toolbar.*

class DetalhesChamado : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_chamado)
        insertToolbar()

        toolbar.setOnClickListener(this)
        inflateForm()
    }

    private fun inflateForm(){
        var chamado = Chamado()
        val id = intent.getIntExtra("id", 0)

        val repository = ChamadoRepository(this)
        chamado = repository.getChamado(id)
        txtTitle.setText(chamado.titulo)
        txtMotivo.setText(chamado.descricao)

    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Detalhes Chamado"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.toolbar){
            onBackPressed()
        }
    }

}