package com.br.capacitap4mobile2.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.br.capacita.Model.Curso
import com.br.capacitap4mobile2.R
import com.squareup.picasso.Picasso

class CursoDetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curso_detalhe)

        val txtTituloCurso = findViewById<TextView>(R.id.textTituloDoCurso)
        val txtDescricaoCurso = findViewById<TextView>(R.id.textDescricaoDoCurso)
        val imgViewCurso = findViewById<ImageView>(R.id.imageView2)

        val intentCurso = intent.extras?.getParcelable<Curso>("curso")

        txtTituloCurso.text = intentCurso?.nome
        txtDescricaoCurso.text = intentCurso?.descricao
        Picasso.get()
            .load(intentCurso?.img_curso)
            .into(imgViewCurso)
    }
}