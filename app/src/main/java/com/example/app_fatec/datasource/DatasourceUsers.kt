package com.example.app_fatec.datasource

import com.example.app_fatec.model.Usuario

class DatasourceUsers {
    companion object{
        fun getUsuario(): ArrayList<Usuario>{
            var usuario = ArrayList<Usuario>()
            
            usuario.add(Usuario(1, "Ingrid", "27/06/2000", "passei", "123", "dev", "", ""))
            return  usuario
        }
    }
}