package com.example.app_fatec.repository

import android.content.ContentValues
import android.content.Context
import com.example.app_fatec.dataBase.DataBaseHelper
import com.example.app_fatec.datasource.DatabaseDefinitions
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

    fun login(email: String){
        val db = dbHelper.readableDatabase
        val valores = ContentValues()
        valores.get(email)
    }

    fun update(usuario: Usuario){
        val db = dbHelper.writableDatabase
    }
}