package br.unipar.trabalhob2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TreinosAdapter(private val eventos: List<Treino>) : RecyclerView.Adapter<TreinosAdapter.TreinoViewHolder>() {

    class TreinoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtEvento: TextView = view.findViewById(R.id.text_evento)
        val txtDescricao: TextView = view.findViewById(R.id.input_descricao)
        val txtTotalJogadores: TextView = view.findViewById(R.id.input_total_jogadores)
        val txtDataHora: TextView = view.findViewById(R.id.input_total_jogadores)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listar_eventos, parent, false)
        return TreinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreinoViewHolder, position: Int) {
        val evento = eventos[position]
        holder.txtEvento.text = evento.nome
        holder.txtDescricao.text = evento.descricao
        holder.txtTotalJogadores.text = "Total de Jogadores: ${evento.totalJogadores}"
        holder.txtDataHora.text = "Data: ${evento.data} - Hora: ${evento.hora}"
    }

    override fun getItemCount() = eventos.size
}