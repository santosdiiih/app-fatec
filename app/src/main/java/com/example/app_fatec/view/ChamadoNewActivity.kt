package com.example.app_fatec.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.app_fatec.R
import com.example.app_fatec.datasource.DatabaseDefinitions
import com.example.app_fatec.model.Chamado
import com.example.app_fatec.repository.ChamadoRepository
import kotlinx.android.synthetic.main.activity_chamado_new.*
import kotlinx.android.synthetic.main.activity_new_user.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*
import kotlin.collections.ArrayList

class ChamadoNewActivity : AppCompatActivity(), View.OnClickListener {
    private val SALVAR: String = "Salvar";
    private val CANCELAR: String = "Cancelar";
    private val ERROR: String = "Error"
    private var bitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chamado_new)

        insertToolbar()
        imageButton.setOnClickListener(this)
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.scren_new_chamado)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val builderDialog = AlertDialog.Builder(this)
        when(item.itemId) {
            R.id.menuSalvar -> {
                if(validForm()){
                    saveChamado()
                }
            }
            R.id.menuCancelar -> {
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
            else -> {
                alert(CANCELAR)
            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null){
            val inputString = contentResolver.openInputStream( data.data!!)
            bitmap = BitmapFactory.decodeStream(inputString)
            fotoChamado.scaleType = ImageView.ScaleType.CENTER_CROP
            fotoChamado.setImageBitmap(bitmap)

        }
    }

    private fun validForm(): Boolean{
        var valida = true;
        if(textTituloChamado.length() < 3){
            inputTextTitutloChamado.isErrorEnabled = true
            inputTextTitutloChamado.error = "Digite um titulo valído"
            valida = false
        }
        else {
            inputTextTitutloChamado.isErrorEnabled = false
            inputTextTitutloChamado.error = null
        }
        if(txtMotivoChamado.length() < 4){
            inputTextMotivoChamado.isErrorEnabled = true
            inputTextMotivoChamado.error = "Digite um motivo com mais de 10 caracteres"
            valida = false
        }
        else {
            inputTextMotivoChamado.isErrorEnabled = false
            inputTextMotivoChamado.error = null
        }
        return valida
    }

    override fun onClick(view: View){
        val id = view.id
        when(id){
           R.id.imageButton -> {
               val intent = Intent(Intent.ACTION_GET_CONTENT)
               intent.type = "image/*"
               startActivityForResult(intent, 5000)
           }
       }
    }

    private fun saveChamado(){
        val dateNow = Calendar.getInstance().time

        val comentario: ArrayList<String>? = null
         comentario?.add("tetes")

        val chamado = Chamado(
            idChamado = 0,
            dataAtualizacao =  "27-06-200",
            titulo = textTituloChamado.text.toString(),
            dataFechamento = "27-06-2000",
            descricao = txtMotivoChamado.text.toString(),
            dataAbertura = "27-06-2000",
            imagemChamado = bitmap,
            numeroChamado = "",
            comentario = comentario

        )
        // idStatus,dataAtualizacao,idUsuario,titulo,dataFechamento,descricao,dataAbertura
        val repository = ChamadoRepository(this)
        val id = repository.saveChamado(chamado)
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
                    onBackPressed()
                }
                builderDialog.show()
                //limparFormulario()
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
                builderDialog.setMessage("Sinto muito não foi possivel salvar seu chamado\n\n Tente novamente mais tarde")
                builderDialog.setIcon(R.drawable.ic_baseline_clear_30)
                builderDialog.setPositiveButton("OK") { _, _ ->
                    onBackPressed()
                }
                builderDialog.show()
            }
        }
    }

}