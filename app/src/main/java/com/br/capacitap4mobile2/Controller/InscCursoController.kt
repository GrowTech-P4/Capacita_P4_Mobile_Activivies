package com.br.capacitap4mobile2.Controller

import com.br.capacita.Interfaces.CursoService
import com.br.capacita.Model.Curso
import com.br.capacitap4mobile2.Connection.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InscCursoController {
    fun inscCurso(token: String, _idCurso: String){
        val responseUsuario = RetrofitClient.abrirConexao(CursoService::class.java)
        responseUsuario.inscCurso(token,_idCurso).enqueue(object : Callback<Curso> {
            override fun onResponse(call: Call<Curso>, response: Response<Curso>) {
                val teste = response.body()
                println("RESPONSE "+teste)

            }

            override fun onFailure(call: Call<Curso>, t: Throwable) {
                println("ERRO CONTROLLER INSCRICAO CURSO >>>>>>>>>> ${t}")
            }

        })
    }
}