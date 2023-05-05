package com.example.app_fatec.view

import android.content.Intent
import android.database.CursorWindow
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_fatec.R
import com.example.app_fatec.adapter.ChamadosAdapter
import com.example.app_fatec.repository.ChamadoRepository
import kotlinx.android.synthetic.main.activity_scren_chamados.*
import kotlinx.android.synthetic.main.toolbar.*
import java.lang.reflect.Field


class ScrenChamadosActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
            field.setAccessible(true)
            field.set(null, 100 * 1024 * 1024) //the 100MB is the new size
        } catch (e: Exception) {
            e.printStackTrace()
        }

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