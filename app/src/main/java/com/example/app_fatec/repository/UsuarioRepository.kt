package com.example.app_fatec.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.app_fatec.dataBase.DataBaseHelper
import com.example.app_fatec.datasource.DatabaseDefinitions
import com.example.app_fatec.model.Chamado
import com.example.app_fatec.model.Usuario

class UsuarioRepository(context: Context){

    private val dbHelper = DataBaseHelper(context)

    fun save(usuario: Usuario): Int{
        val db = dbHelper.writableDatabase
        val valores = ContentValues()
        valores.put(DatabaseDefinitions.Solicitante.Columns.NOME, usuario.nome)
        valores.put(DatabaseDefinitions.Solicitante.Columns.CONTATO, usuario.contato)
        valores.put(DatabaseDefinitions.Solicitante.Columns.EMAIL, usuario.email)
        valores.put(DatabaseDefinitions.Solicitante.Columns.SENHA, usuario.senha)
        valores.put(DatabaseDefinitions.Solicitante.Columns.GESTOR, usuario.gestor)
        valores.put(DatabaseDefinitions.Solicitante.Columns.DATA_NASCIMENTO, usuario.dataNascimento)
        valores.put(DatabaseDefinitions.Solicitante.Columns.GESTOR, usuario.gestor)

        val id = db.insert(DatabaseDefinitions.Solicitante.TABLE_NAME, null, valores)
        return id.toInt()
    }

    @SuppressLint("Range")
    fun login(email: String, senha: String) : Usuario{
        val db = dbHelper.readableDatabase
        val selection = "${DatabaseDefinitions.Solicitante.Columns.EMAIL} = ? AND ${DatabaseDefinitions.Solicitante.Columns.SENHA} = ?"
        val selectionArgs = arrayOf(email, senha)

        val cursor = db.query(
            DatabaseDefinitions.Solicitante.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        var usuario = Usuario()
        if(cursor != null){
            cursor.moveToNext()
            usuario.idSolicitante = cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.ID_SOLICITANTE))
            usuario.nome = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.NOME))
            usuario.email = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.EMAIL))
            usuario.contato = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.CONTATO))
            usuario.gestor = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.GESTOR))
            usuario.senha = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.SENHA))
            usuario.dataNascimento = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.DATA_NASCIMENTO))
            usuario.funcao = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Solicitante.Columns.FUNCAO))
        }
        return usuario
    }

    fun getUsers() : ArrayList<Usuario>{
        // colocando o banco em modo leitura
        val db = dbHelper.readableDatabase


        var usuarios = ArrayList<Usuario>()

        return usuarios
    }

    fun getUser(id: Int){}

    fun deletUser(id: Int){}

    fun update(usuario: Usuario){
        val db = dbHelper.writableDatabase
    }
}