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
        db.execSQL(CREATE_TABLE_STATUS)
        db.execSQL(CREATE_TABLE_SOLICITANTE)
        db.execSQL(CREATE_TABLE_CHAMADO)
        db.execSQL(CREATE_TABLE_TECNICO)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    companion object{
        private const val DATABASE_NAME = "dbSuporte"
        private const val DATABASE_VERSION = 1

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
                "${DatabaseDefinitions.Chamado.Columns.ID_CHAMADO} INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "${DatabaseDefinitions.Chamado.Columns.TITULO} VARCHAR(50) NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.DATA_ABERTURA} DATE NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.DATA_ATUALIZACAO} DATE NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.DATA_FECHAMENTO} VARCHAR(50), " +
                "${DatabaseDefinitions.Chamado.Columns.DESCRICAO} VARCHAR(150), " +
                "${DatabaseDefinitions.Chamado.Columns.ID_STATUS} INTEGER NOT NULL, " +
                "${DatabaseDefinitions.Chamado.Columns.ID_USUARIO}INTEGER NOT NULL);"
    }

}