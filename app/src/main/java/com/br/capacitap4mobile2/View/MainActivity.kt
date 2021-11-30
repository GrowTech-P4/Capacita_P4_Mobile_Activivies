package com.br.capacitap4mobile2.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.capacitap4mobile2.Adapter.AdapterCurso
import com.br.capacitap4mobile2.Connection.RetrofitClient
import com.br.capacitap4mobile2.Interfaces.CursoService
import com.br.capacitap4mobile2.Model.Curso
import com.br.capacitap4mobile2.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val conta = findViewById<ImageView>(R.id.ic_conta)
        conta.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //RECUPERAR O RECYCLERVIEW DO LAYOUT
        val recylerView_cursos = findViewById<RecyclerView>(R.id.recylerView_cursos1)

        //DEFINE O CONTEXTO E SENTIDO DO ALINHAMENTO VERTICAL OU HORIZONTAL
        recylerView_cursos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //SETA OTIMIZA LISTA NO RECYCLEDVIEW
        recylerView_cursos.setHasFixedSize(true)

        //CONFIGURAR O ADAPTER
        val listaCursos: MutableList<Curso> = mutableListOf()
        val context = this

        //REQUISICAO DO RETROFIT
        val responseCursos = RetrofitClient.abrirConexao(CursoService::class.java)
        responseCursos.getCurso().enqueue(object : Callback<List<Curso>>, AdapterCurso.ClickCurso {
            override fun onResponse(
                call: Call<List<Curso>>,
                response: Response<List<Curso>>
            ) {

                val lista = response.body()

                lista?.forEach {
                    listaCursos.add(it)
                    println(lista)
                }

                //CONFIGURAR O ADAPTER
                val adapterCurso = AdapterCurso(context, listaCursos, this)
                recylerView_cursos.adapter = adapterCurso

            }

            override fun clickCurso(curso: Curso) {
                println("Clicando....!!!! ${curso.descricao}")
            }

            override fun onFailure(call: Call<List<Curso>>, t: Throwable) {
                println("FALHA>>>>>>>>>>>>>>>>>>>>>>>> ${t.message}")
            }

        })

    }
}