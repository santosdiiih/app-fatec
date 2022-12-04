package com.example.app_fatec.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_fatec.R
import com.example.app_fatec.adapter.ChamadosAdapter
import com.example.app_fatec.datasource.DatasourceChamados
import com.example.app_fatec.repository.ChamadoRepository
import kotlinx.android.synthetic.main.activity_scren_chamados.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.sql.DataSource

class ScrenChamadosActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scren_chamados)

        insertToolbar()
        buttonNewChamado.setOnClickListener(this)
    }

    override fun onResume() {
        chamadosReciclerView()
        super.onResume()
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Home"
    }

    private fun chamadosReciclerView(){
        reciclerViewChamado.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        val repo = ChamadoRepository(this)
        reciclerViewChamado.adapter = ChamadosAdapter(repo.getChamados())
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.buttonNewChamado -> {
                val intent = Intent(this, ChamadoNewActivity::class.java)
                startActivity(intent)
            }
            R.id.toolbar -> {
                onBackPressed()
            }
        }
    }
}