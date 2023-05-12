package com.example.app_fatec.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.example.app_fatec.dataBase.DataBaseHelper
import com.example.app_fatec.datasource.DatabaseDefinitions
import com.example.app_fatec.model.Comentario


class ComentarioRepository(context: Context) {
    private val dbHelper = DataBaseHelper(context)

    fun saveComentario(comentario: Comentario): Int{
        val db = dbHelper.writableDatabase
        val values = ContentValues()

        values.put(DatabaseDefinitions.ComentarioChamado.Columns.COMENTARIO, comentario.comentario)
        values.put(DatabaseDefinitions.ComentarioChamado.Columns.NOME_AUTOR, comentario.nomeUsuario)

        val id = db.insert(DatabaseDefinitions.ComentarioChamado.TABLE_NAME, null, values)
        return id.toInt()
    }

    @SuppressLint("Range")
    fun getComentario(): ArrayList<Comentario> {
        val db = dbHelper.readableDatabase
        val projection = arrayOf(DatabaseDefinitions.ComentarioChamado.Columns.ID_COMENTARIO,
            DatabaseDefinitions.ComentarioChamado.Columns.COMENTARIO,
            DatabaseDefinitions.ComentarioChamado.Columns.NOME_AUTOR,
            )
        val cursor = db.query(
            DatabaseDefinitions.ComentarioChamado.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        var comentarios = ArrayList<Comentario>()
        if(cursor != null){
            while (cursor.moveToNext()){
                var comentario = Comentario(
                    idComentario =  cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.ComentarioChamado.Columns.ID_COMENTARIO)),
                    comentario =  cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.ComentarioChamado.Columns.COMENTARIO)),
                    nomeUsuario = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.ComentarioChamado.Columns.NOME_AUTOR)),
                )
                comentarios.add(comentario)
            }
        }
        return comentarios
    }
}