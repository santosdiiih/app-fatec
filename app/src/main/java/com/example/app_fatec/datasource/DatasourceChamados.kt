package com.example.app_fatec.datasource

import com.example.app_fatec.model.Chamado

class DatasourceChamados {
    companion object{
        fun getChamado(): ArrayList<Chamado>{
            var chamado = ArrayList<Chamado>()
            chamado.add(Chamado(1 ,"Instalação", "29/04/2022","02/05/2022", "02/05/2022", "Problema na rede", "2", "2", ))
            chamado.add(Chamado(1 ,"Equipamento", "07/10/2022","-", "20/10/2022", "falta de cabo de energia", "5", "1"))
            return chamado;
        }
    }
}