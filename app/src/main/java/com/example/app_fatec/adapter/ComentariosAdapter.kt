package com.example.app_fatec.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fatec.R
import com.example.app_fatec.model.Chamado
import com.example.app_fatec.model.Comentario
import com.example.app_fatec.view.DetalhesChamado
import kotlinx.android.synthetic.main.layout_card_chamado.view.imageChamado
import kotlinx.android.synthetic.main.layout_card_chamado.view.textComentario
import kotlinx.android.synthetic.main.layout_card_chamado.view.textDescChamado
import kotlinx.android.synthetic.main.layout_card_chamado.view.textDetalhes
import kotlinx.android.synthetic.main.layout_card_chamado.view.textTitleChamado

class ComentariosAdapter(var listaComentarios: ArrayList<Comentario>, var listaChamado: ArrayList<Chamado>) : RecyclerView.Adapter<ComentariosAdapter.ComentarioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComentariosAdapter.ComentarioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_card_comentario, parent, false)
        return ComentariosAdapter.ComentarioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ComentarioViewHolder, position: Int) {
        val comentario = listaComentarios[position]
        val chamado = listaChamado[position]
        holder.bind(comentario, chamado)
    }

    override fun getItemCount(): Int {
        return listaComentarios.size
    }



    class ComentarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(comentario: Comentario, chamado: Chamado){
             itemView.textTitleChamado.text = comentario.nomeUsuario
             itemView.textDescChamado.text = comentario.comentario

            itemView.textDetalhes.setOnClickListener{
                val intent = Intent(itemView.context, DetalhesChamado::class.java)
                intent.putExtra("idChamado", chamado.idChamado)
                intent.putExtra("idComentario", comentario.idComentario)
                itemView.context.startActivity(intent)
            }

                    }
    }

}