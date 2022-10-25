package com.example.app_fatec.datasource

import com.example.app_fatec.model.Chamado

class DatasourceChamados {
    companion object{
        fun getChamado(): ArrayList<Chamado>{
            var chamado = ArrayList<Chamado>()
            chamado.add(Chamado(1 ,"Instalação", "29/04/2022","02/05/2022", "02/05/2022", "Problema na rede", "2", "2", "media", "fechado"))
            chamado.add(Chamado(1 ,"Equipamento", "07/10/2022","-", "20/10/2022", "falta de cabo de energia", "5", "1", "alta", "em andamento"))
            chamado.add(Chamado(1 ,"Alteração de Cadastro", "29/04/2022", "24/10/2022", "24/10/2022", "monitor com resolução errada", "2", "2", "alta", "cancelado"))
            chamado.add(Chamado(1 ,"Instalação", "29/04/2022", "30/06/2021", "30/06/2021", "preciso de um mouse novo", "4", "3", "Baixa", "fechado"))
            chamado.add(Chamado(1 ,"Equipamentos", "29/04/2022", "-", "28/05/2022", "quero um monitor a mais", "", "1", "alta", "em andamento"))
            return chamado;
        }
    }
}