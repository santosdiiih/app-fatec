package com.example.app_fatec.datasource

class DatabaseDefinitions {

    object Status{
        const val TABLE_NAME = "tblStatus"
        object Columns{
            const val ID_STATUS = "idStatus"
            const val SATUS = "status"
        }
    }

    object Solicitante {
        const val TABLE_NAME = "tblUsuario"
        object Columns {
            const val ID_SOLICITANTE = "idSolicitante"
            const val NOME = "nome"
            const val DATA_NASCIMENTO = "dataNascimento"
            const val EMAIL = "email"
            const val SENHA = "senha"
            const val FUNCAO = "funcao"
            const val GESTOR = "gestor"
            const val CONTATO = "contato"
        }
    }

    object Chamado {
        const val TABLE_NAME = "tblChamado"
        object Columns {
            const val ID_CHAMADO = "idChamado"
            const val TITULO = "titulo"
            const val DATA_ABERTURA = "dataAbertura"
            const val DATA_ATUALIZACAO = "dataAtualizacao"
            const val DATA_FECHAMENTO = "dataFechamento"
            const val DESCRICAO = "descricao"
            const val ID_USUARIO = "idUsuario"
            const val ID_STATUS = "idStatus"
        }
    }

    object Tecnico{
        const val TABLE_NAME = "tblTecnico"
        object Columns {
            const val ID_TECNICO = "idSolicitante"
            const val NOME = "nome"
            const val DATA_NASCIMENTO = "dataNascimento"
            const val EMAIL = "email"
            const val SENHA = "senha"
            const val FUNCAO = "funcao"
            const val GESTOR = "gestor"
            const val CONTATO = "contato"
            const val ID_CHAMADO = "idChamado"
        }
    }

    object ComentarioChamado{
        const val TABLE_NAME = "tblComentarioChamado"
        object Columns {
            const val ID_CHAMADO = "idChamado"
            const val COMENTARIO = "comentario"
            const val ID_AUTOR = "idAutor"
        }
    }
}