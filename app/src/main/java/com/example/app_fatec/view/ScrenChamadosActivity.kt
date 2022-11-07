package com.example.app_fatec.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_fatec.R
import com.example.app_fatec.adapter.ChamadosAdapter
import com.example.app_fatec.datasource.DatasourceChamados
import kotlinx.android.synthetic.main.activity_scren_chamados.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.sql.DataSource

class ScrenChamadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scren_chamados)

        insertToolbar()
        chamadosReciclerView()
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Home"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun chamadosReciclerView(){
        reciclerViewChamado.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        reciclerViewChamado.adapter = ChamadosAdapter(DatasourceChamados.getChamado())
    }
}