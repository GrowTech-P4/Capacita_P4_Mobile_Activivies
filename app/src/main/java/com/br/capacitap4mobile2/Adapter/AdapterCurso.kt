package com.br.capacitap4mobile2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.capacita.Model.Curso
import com.br.capacitap4mobile2.R
import com.squareup.picasso.Picasso

class AdapterCurso(private val context: Context, val cursos: MutableList<Curso>): RecyclerView.Adapter<AdapterCurso.CursoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.curso_item, parent, false)
        val holder = CursoViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {

        Picasso.get()
            .load(cursos[position].img_curso)
            .into(holder.img)
        holder.nome.text = cursos[position].nome
        holder.descricao.text = cursos[position].descricao
        holder.valor.text = cursos[position].valor
    }

    override fun getItemCount(): Int = cursos.size

    inner class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img         = itemView.findViewById<ImageView>(R.id.imgCurso)
        val nome        = itemView.findViewById<TextView>(R.id.nomeCurso)
        val descricao   = itemView.findViewById<TextView>(R.id.descricaoCurso)
        val valor       = itemView.findViewById<TextView>(R.id.valorCurso)
    }

}