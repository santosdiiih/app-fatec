package com.example.app_fatec.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.app_fatec.datasource.DatabaseDefinitions

/*
 o primeiro é o contexto que quem vai nos informar é quem esta chamando a classe helper
 o segundo parametro é o nome do banco
 o terceiro é inultil para a aplicação
 o quarto parametro é a versão do banco (informação importante para o desenvolvimento
 */
class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_TECNICO)
        db.execSQL(CREATE_TABLE_SOLICITANTE)
        db.execSQL(CREATE_TABLE_STATUS)
        db.execSQL(CREATE_TABLE_CHAMADO)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(CREATE_TABLE_COMENTARIO)
    }
    companion object{
        private const val DATABASE_NAME = "app"
        private const val DATABASE_VERSION = 7

        private const val DROP_TABLE_CHAMADO = "DROP TABLE ${DatabaseDefinitions.Chamado.TABLE_NAME}"
        private const val DROP_TABLE_USUARIO = "DROP TABLE ${DatabaseDefinitions.Solicitante.TABLE_NAME}"
        private const val DROP_TABLE_TECNICO = "DROP TABLE ${DatabaseDefinitions.Tecnico.TABLE_NAME}"
        private const val DROP_TABLE_STATUS = "DROP TABLE ${DatabaseDefinitions.Status.TABLE_NAME}"

        private const val CREATE_TABLE_STATUS = "CREATE TABLE ${DatabaseDefinitions.Status.TABLE_NAME}(" +
                "${DatabaseDefinitions.Status.Columns.ID_STATUS} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "${DatabaseDefinitions.Status.Columns.SATUS} VARCHAR );"

        private const val CREATE_TABLE_TECNICO =  "CREATE TABLE ${DatabaseDefinitions.Tecnico.TABLE_NAME}(" +
                "${DatabaseDefinitions.Tecnico.Columns.ID_TECNICO} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "${DatabaseDefinitions.Tecnico.Columns.NOME} VARCHAR(50) NOT NULL," +
                "${DatabaseDefinitions.Tecnico.Columns.EMAIL} VARCHAR(100) NOT NULL," +
                "${DatabaseDefinitions.Tecnico.Columns.SENHA} VARCHAR(20) NOT NULL," +
                "${DatabaseDefinitions.Tecnico.Columns.GESTOR} VARCHAR(50)," +
                "${DatabaseDefinitions.Tecnico.Columns.FUNCAO} VARCHAR(50)," +
                "${DatabaseDefinitions.Tecnico.Columns.DATA_NASCIMENTO} DATE," +
                "${DatabaseDefinitions.Tecnico.Columns.CONTATO} VARCHAR(20) NOT NULL," +
                "${DatabaseDefinitions.Tecnico.Columns.ID_CHAMADO}INTEGER NOT NULL);"

        private const val CREATE_TABLE_SOLICITANTE =  "CREATE TABLE ${DatabaseDefinitions.Solicitante.TABLE_NAME}(" +
                "${DatabaseDefinitions.Solicitante.Columns.ID_SOLICITANTE} INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "${DatabaseDefinitions.Solicitante.Columns.NOME} VARCHAR(50) NOT NULL, " +
                "${DatabaseDefinitions.Solicitante.Columns.EMAIL} VARCHAR(100) NOT NULL, " +
                "${DatabaseDefinitions.Solicitante.Columns.SENHA} VARCHAR(20) NOT NULL, " +
                "${DatabaseDefinitions.Solicitante.Columns.GESTOR} VARCHAR(50), " +
                "${DatabaseDefinitions.Solicitante.Columns.FUNCAO} VARCHAR(50), " +
                "${DatabaseDefinitions.Solicitante.Columns.DATA_NASCIMENTO} DATE, " +
                "${DatabaseDefinitions.Solicitante.Columns.CONTATO} VARCHAR(20) NOT NULL);"

        private const val CREATE_TABLE_CHAMADO =  "CREATE TABLE ${DatabaseDefinitions.Chamado.TABLE_NAME}(" +
                "${DatabaseDefinitions.Chamado.Columns.ID_CHAMADO} INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "${DatabaseDefinitions.Chamado.Columns.TITULO} VARCHAR(50) NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.IMAGEM_CHAMADO} BLOB, " +
                "${DatabaseDefinitions.Chamado.Columns.DATA_ABERTURA} VARCHAR(50) NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.DATA_ATUALIZACAO} VARCHAR(50) NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.DATA_FECHAMENTO} VARCHAR(50), " +
                "${DatabaseDefinitions.Chamado.Columns.DESCRICAO} VARCHAR(150));"

        private const val CREATE_TABLE_COMENTARIO =  "CREATE TABLE ${DatabaseDefinitions.ComentarioChamado.TABLE_NAME}(" +
                "${DatabaseDefinitions.ComentarioChamado.Columns.ID_COMENTARIO} INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "${DatabaseDefinitions.ComentarioChamado.Columns.COMENTARIO} VARCHAR(100), " +
                "${DatabaseDefinitions.ComentarioChamado.Columns.NOME_AUTOR} VARCHAR(50), " +
                "${DatabaseDefinitions.ComentarioChamado.Columns.ID_CHAMADO} INTEGER);"

    }

}