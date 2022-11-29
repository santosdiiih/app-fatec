package com.example.app_fatec.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fatec.R
import com.example.app_fatec.model.Chamado
import kotlinx.android.synthetic.main.layout_card_chamado.view.*


class ChamadosAdapter(var listaChamados: ArrayList<Chamado>) : RecyclerView.Adapter<ChamadosAdapter.ChamadoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChamadoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_card_chamado, parent, false)
        return ChamadoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChamadoViewHolder, position: Int) {
        val chamado = listaChamados[position]
        holder.bind(chamado)
    }

    override fun getItemCount(): Int {
        return listaChamados.size
    }

    class ChamadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(chamado: Chamado){
            itemView.textTitleChamado.text = chamado.titulo
            itemView.textDescChamado.text = chamado.descricao
            //itemView.textPrioridade.text = chamado.idPrioridade
        }
    }
}