package com.example.app_fatec.datasource

import com.example.app_fatec.model.Usuario

class DatasourceUsers {
    companion object{
        fun getUsuario(): ArrayList<Usuario>{
            var usuario = ArrayList<Usuario>()
            
            usuario.add(Usuario(1, "Ingrid", "27/06/2000", "passei", "123", "dev", "", ""))
            usuario.add(Usuario(2, "debora", "20/07/2000", "email@sei_la", "321", "n1", "", ""))
            usuario.add(Usuario(3, "larissa", "02/11/2003", "@teste.com", "456", "estag", "", ""))
            usuario.add(Usuario(4, "natalia", "", "@testando", "654", "logistica", "", ""))

            return  usuario
        }
    }
}