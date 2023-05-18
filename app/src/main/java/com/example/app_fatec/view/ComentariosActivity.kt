package com.example.app_fatec.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.app_fatec.R
import com.example.app_fatec.model.Comentario
import com.example.app_fatec.repository.ComentarioRepository
import kotlinx.android.synthetic.main.activity_chamado_new.textTituloChamado
import kotlinx.android.synthetic.main.activity_comentarios.buttonEnviar
import kotlinx.android.synthetic.main.activity_comentarios.txtMotivoComentario


class ComentariosActivity : AppCompatActivity(), View.OnClickListener {

    private val SALVAR: String = "Salvar";
    private val CANCELAR: String = "Cancelar";
    private val ERROR: String = "Error"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentarios)

        buttonEnviar.setOnClickListener(this)
    }

    private fun saveComentario(){
        val idComentario = intent.getIntExtra("idComentario", 0)
        val idChamado = intent.getIntExtra("idChamado", 0)

        val comentario = Comentario(
            idComentario = 0,
            comentario = txtMotivoComentario.text.toString(),
            nomeUsuario = "Ingrid"
        )
        val repository = ComentarioRepository(this)
        val id = repository.saveComentario(comentario)
        if(id > 0){
            alert(SALVAR)
        }
        else{
            alert(ERROR)
        }
    }

    private fun alert(call: String){
        val builderDialog = AlertDialog.Builder(this)
        when (call) {
            SALVAR -> {
                builderDialog.setTitle("Chamado Cadastrado")
                builderDialog.setMessage("Seu chamado foi aberto, aguarde ser atendido\n\n")
                builderDialog.setIcon(R.drawable.ic_baseline_done_24)
                builderDialog.setPositiveButton("OK"){ _, _ ->
                    val intent = Intent(this, ComentariosActivity::class.java)
                    startActivity(intent)
                }
                builderDialog.show()
            }
            CANCELAR -> {
                builderDialog.setTitle(getString(R.string.dialog_title_newUser))
                builderDialog.setMessage(getString(R.string.dialog_newUser))
                builderDialog.setIcon(R.drawable.ic_baseline_clear_30)
                builderDialog.setPositiveButton(getString(R.string.dialog_button_yes)) { _, _ ->
                    onBackPressed()
                }
                builderDialog.setNegativeButton(getString(R.string.dialog_button_not)) { _, _ ->
                    textTituloChamado.requestFocus()
                }
                builderDialog.show()
            }
            ERROR -> {
                builderDialog.setTitle("Erro ao salvar os dados")
                builderDialog.setMessage("Sinto Muito não foi Possivel salvar seu Comentario\n\n Tente Novamente mais Tarde")
                builderDialog.setIcon(R.drawable.ic_baseline_clear_30)
                builderDialog.setPositiveButton("OK") { _, _ ->
                    onBackPressed()
                }
                builderDialog.show()
            }
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        when(id){
            R.id.buttonEnviar -> {
                saveComentario()
            }
        }
    }
}