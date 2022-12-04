package com.example.app_fatec.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.app_fatec.R
import com.example.app_fatec.model.Usuario
import com.example.app_fatec.repository.UsuarioRepository
import kotlinx.android.synthetic.main.activity_chamado_new.*
import kotlinx.android.synthetic.main.activity_new_user.*
import kotlinx.android.synthetic.main.toolbar.*
import java.lang.Error

class NewUser : AppCompatActivity() {
    private val SALVAR: String = "Salvar";
    private val CANCELAR: String = "Cancelar";
    private val ERROR: String = "Error"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        insertToolbar()
    }
    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = getString(R.string.cadastro)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuSalvar -> {
                if(validForm()){
                   saveUsuario()
                }
            }
            R.id.menuCancelar -> {
                alert(CANCELAR)
            }
            else -> {
                onBackPressed()
            }
        }
        return true
    }

    private fun saveUsuario(){
        val usuario = Usuario(
            idSolicitante = 0,
            nome = cadastroNome.text.toString(),
            dataNascimento = cadastroDataNascimento.text.toString(),
            email = cadastroEmail.text.toString(),
            senha = cadastroSenha.text.toString(),
            gestor = cadastroGestor.text.toString(),
            funcao = cadastroSpinnerFuncao.selectedItem.toString(),
            contato = cadastroContato.text.toString()
        )
        val repository = UsuarioRepository(this)
        val id = repository.save(usuario)
        if(id != 0){
            alert(ERROR)
        }
    }

    private fun validForm(): Boolean{
        var valida = true;
        if(cadastroNome.length() < 3){
            inputTextCadastroNome.isErrorEnabled = true
            inputTextCadastroNome.error = "Digite um nome valído"
            valida = false
        }
        else {
            inputTextCadastroNome.isErrorEnabled = false
            inputTextCadastroNome.error = null
        }
        if(cadastroSenha.length() < 5){
            inputTextcadastroSenha.isErrorEnabled = true
            inputTextcadastroSenha.error = "Digite uma senha com mais de 5 digitos"
            valida = false
        }
        else {
            inputTextcadastroSenha.isErrorEnabled = false
            inputTextcadastroSenha.error = null
        }
        if(cadastroEmail.length() < 5){
            inputTextcadastroEmail.isErrorEnabled = true
            inputTextcadastroEmail.error = "Digite um email valido"
            valida = false
        }
        else{
            inputTextcadastroEmail.isErrorEnabled = false
            inputTextcadastroEmail.error = null
        }
        return valida
    }

    private fun limparFormulario(){
        cadastroNome.setText("")
        cadastroEmail.setText("")
        cadastroSenha.setText("")

    }

    private fun alert(call: String){
        val builderDialog = AlertDialog.Builder(this)
         when (call) {
            SALVAR -> {
                builderDialog.setTitle("Usuario Cadastrado")
                builderDialog.setMessage("Agora você já consegue fazer login na plataforma\n\n")
                builderDialog.setIcon(R.drawable.ic_baseline_done_24)
                builderDialog.setPositiveButton("OK"){ _, _ ->
                    onBackPressed()
                }
                builderDialog.show()
                limparFormulario()
            }
            CANCELAR -> {
                builderDialog.setTitle(getString(R.string.dialog_title_newUser))
                builderDialog.setMessage(getString(R.string.dialog_newUser))
                builderDialog.setIcon(R.drawable.ic_baseline_clear_30)
                builderDialog.setPositiveButton(getString(R.string.dialog_button_yes)) { _, _ ->
                    onBackPressed()
                }
                builderDialog.setNegativeButton(getString(R.string.dialog_button_not)) { _, _ ->
                    cadastroNome.requestFocus()
                }
                builderDialog.show()
            }
             ERROR -> {
                 builderDialog.setTitle("Erro ao salvar os dados")
                 builderDialog.setMessage("Sinto muito não foi possivel salvar seu cadastro\n\n Tente novamente mais tarde")
                 builderDialog.setIcon(R.drawable.ic_baseline_clear_30)
                 builderDialog.setPositiveButton("OK") { _, _ ->
                     onBackPressed()
                 }
                 builderDialog.show()
             }
        }
    }

}