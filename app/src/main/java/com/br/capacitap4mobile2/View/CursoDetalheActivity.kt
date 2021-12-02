package com.br.capacitap4mobile2.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.br.capacita.Controller.LoginController
import com.br.capacita.Model.Curso
import com.br.capacita.Model.TipoDeficiencia
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.Controller.SessionManager
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

        val botao = findViewById<Button>(R.id.button)

        val sessionManager = SessionManager(this)
        botao.setOnClickListener {
            if (sessionManager.fetchAuthToken() == null) {
                Toast.makeText(this, "Necessário Efetuar Login", Toast.LENGTH_LONG).show()
                val home = Intent(this, LoginActivity::class.java)
                startActivity(home)
            } else {
                println("SESSION MANAGER CURSO DETALHE ACTIVITY " + sessionManager.fetchAuthToken())
                println("ID CURSO DETALHE ACTIVITY = " + intentCurso?._id)
            }
        }

    }

}