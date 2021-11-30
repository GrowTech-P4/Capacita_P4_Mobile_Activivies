package com.br.capacitap4mobile2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.br.capacitap4mobile2.Model.Curso
import com.br.capacitap4mobile2.R
import com.squareup.picasso.Picasso

class AdapterCurso(val context: Context, val cursos: MutableList<Curso>, var clickCurso: ClickCurso): RecyclerView.Adapter<AdapterCurso.CursoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.curso_item, parent, false)
        val holder = CursoViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {

        var curso: Curso = cursos[position]

        Picasso.get()
            .load(cursos[position].img_curso)
            .into(holder.img)
        holder.nome.text = cursos[position].nome
        holder.descricao.text = cursos[position].descricao
        holder.valor.text = cursos[position].valor

        holder.cardView.setOnClickListener{
            clickCurso.clickCurso(curso)
        }
    }

    override fun getItemCount(): Int = cursos.size

    inner class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img         = itemView.findViewById<ImageView>(R.id.imgCurso)
        val nome        = itemView.findViewById<TextView>(R.id.nomeCurso)
        val descricao   = itemView.findViewById<TextView>(R.id.descricaoCurso)
        val valor       = itemView.findViewById<TextView>(R.id.valorCurso)
        val cardView    = itemView.findViewById<CardView>(R.id.card)
    }

    interface ClickCurso {

        fun clickCurso(curso: Curso)

    }

}