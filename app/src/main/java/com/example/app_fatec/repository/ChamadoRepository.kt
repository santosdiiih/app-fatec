package com.example.app_fatec.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.app_fatec.dataBase.DataBaseHelper
import com.example.app_fatec.datasource.DatabaseDefinitions
import com.example.app_fatec.model.Chamado
import com.example.app_fatec.model.Usuario

class ChamadoRepository(context: Context) {
    private val dbHelper = DataBaseHelper(context)

    fun saveChamado(chamado: Chamado): Int{
        val db = dbHelper.writableDatabase
        val values = ContentValues()

        values.put(DatabaseDefinitions.Chamado.Columns.DATA_ATUALIZACAO, chamado.dataAtualizacao)
        values.put(DatabaseDefinitions.Chamado.Columns.TITULO, chamado.titulo)
        values.put(DatabaseDefinitions.Chamado.Columns.DATA_FECHAMENTO, chamado.dataFechamento)
        values.put(DatabaseDefinitions.Chamado.Columns.DESCRICAO, chamado.descricao)
        values.put(DatabaseDefinitions.Chamado.Columns.DATA_ABERTURA, chamado.dataAbertura)

        val id = db.insert(DatabaseDefinitions.Chamado.TABLE_NAME, null, values)
        return id.toInt()
    }

    @SuppressLint("Range")
    fun getChamados(): ArrayList<Chamado>{
        val db = dbHelper.readableDatabase
        val projection = arrayOf(DatabaseDefinitions.Chamado.Columns.ID_CHAMADO, DatabaseDefinitions.Chamado.Columns.TITULO, DatabaseDefinitions.Chamado.Columns.DESCRICAO)
        val cursor = db.query(
            DatabaseDefinitions.Chamado.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        var chamados = ArrayList<Chamado>()
        if(cursor != null){
            while (cursor.moveToNext()){
                var cliente = Chamado(
                    idChamado =  cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.ID_CHAMADO)),
                    titulo =  cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.TITULO)),
                    descricao = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.DESCRICAO))
                )
                chamados.add(cliente)
            }
        }
        return chamados
    }
    @SuppressLint("Range")
    fun getChamado(id: Int): Chamado{
        val db = dbHelper.readableDatabase
        val selection = "${DatabaseDefinitions.Chamado.Columns.ID_CHAMADO} = ?"
        val selectionArgs = arrayOf(id.toString())
        val cursor = db.query(
            DatabaseDefinitions.Chamado.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        var chamado = Chamado()
        if(cursor != null){
            cursor.moveToNext()
            chamado.idChamado =  cursor.getInt(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.ID_CHAMADO))
            chamado.titulo =  cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.TITULO))
            chamado.dataAbertura = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.DATA_ABERTURA))
            chamado.dataAtualizacao = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.DATA_ATUALIZACAO))
            chamado.dataFechamento = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.DATA_FECHAMENTO))
            chamado.descricao = cursor.getString(cursor.getColumnIndex(DatabaseDefinitions.Chamado.Columns.DESCRICAO))

        }
        else{
            Log.d("chamado", "chamado não encontrado")
        }
        return chamado
    }
    fun deleteChamado(id: Int){}

    fun updateChamado(usuario: Usuario){
        val db = dbHelper.writableDatabase
    }
}