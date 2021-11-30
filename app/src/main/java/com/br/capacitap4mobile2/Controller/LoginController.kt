package com.br.capacita.Controller


import com.br.capacita.Interfaces.LoginInterface
import com.br.capacita.Model.Login
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.Connection.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginController {
    fun login(user:UsuarioPCD):String{
        var message:String = ""
        val responseUsuario = RetrofitClient.abrirConexao(LoginInterface::class.java)
        responseUsuario.login(user).enqueue(object : Callback<Login>{
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                user.token = response.body()!!.token
                user.nome = response.body()!!.usuarioPCD.nome
                user.email = response.body()!!.usuarioPCD.email
                println(response.body())

                println("TOKEN >>> ${user.token} ${user.nome} ${user.email}")
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                message = t.toString()
            }

        })
        return message
    }
}