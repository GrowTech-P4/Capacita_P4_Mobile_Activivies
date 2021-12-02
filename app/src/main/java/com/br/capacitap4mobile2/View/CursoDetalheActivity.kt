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
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class CursoDetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curso_detalhe)

        //PREENCHIMENTO DOS CAMPOS
        val botao = findViewById<Button>(R.id.button)
        val txtTituloCurso = findViewById<TextView>(R.id.textTituloDoCurso)
        val txtDescricaoCurso = findViewById<TextView>(R.id.textDescricaoDoCurso)
        val imgViewCurso = findViewById<ImageView>(R.id.imageView2)
        val txtDataConclusao = findViewById<TextView>(R.id.textDataCurso)
        val txtNomeInstituicao = findViewById<TextView>(R.id.textNomeDaInstituicaoCurso)
        val txtValorCurso = findViewById<TextView>(R.id.textValorCurso)

        val intentCurso = intent.extras?.getParcelable<Curso>("curso")

        txtTituloCurso.text = intentCurso?.nome ?: "Não informado"
        txtDescricaoCurso.text = intentCurso?.descricao ?: "Não informado"
        Picasso.get()
            .load(intentCurso?.img_curso)
            .into(imgViewCurso) ?: "http://10.0.2.2:3000/files/curso.png"
        txtDataConclusao.text = intentCurso?.dataConclusao ?: "Não informado"
        txtNomeInstituicao.text = "FALTA INCLUIR RETORNO DO NOME DO CURSO"
        txtValorCurso.text = "R$ " + intentCurso?.valor ?: "0,0"


        val sessionManager = SessionManager(this)
        botao.setOnClickListener {
            if (sessionManager.fetchAuthToken() == null) {
                Toast.makeText(this, "Necessário Efetuar Login", Toast.LENGTH_LONG).show()
                val home = Intent(this, LoginActivity::class.java)
                startActivity(home)
            } else {
                println("SESSION MANAGER CURSO DETALHE ACTIVITY " + sessionManager.fetchAuthToken())
                val gson = Gson()
                val json = sessionManager.fetchAuthToken()
                val a = gson.fromJson(json, UsuarioPCD::class.java)
                println("ID DA SESSION>>>>>>>>>>>"+a._id)
                println("ID CURSO DETALHE ACTIVITY = " + intentCurso?._id)
            }
        }

    }

}