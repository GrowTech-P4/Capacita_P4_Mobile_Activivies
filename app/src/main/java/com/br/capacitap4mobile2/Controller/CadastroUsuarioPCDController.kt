package com.br.capacita.Controller


import com.br.capacita.Interfaces.UsuarioPCDService
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.Connection.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroUsuarioPCDController {
    fun cadastro(user: UsuarioPCD):String{
        var message:String = ""
        val responseUsuario = RetrofitClient.abrirConexao(UsuarioPCDService::class.java)
        responseUsuario.createUser(user).enqueue(object : Callback<UsuarioPCD>{
            override fun onResponse(call: Call<UsuarioPCD>, response: Response<UsuarioPCD>) {
                println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>usuario cadastrado<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
                println(response.body())
                println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
            }

            override fun onFailure(call: Call<UsuarioPCD>, t: Throwable) {
                message = t.toString()
                println("ERRO=======================$t")
            }

        })



    return message
    }
}