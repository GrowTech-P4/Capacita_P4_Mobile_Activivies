package com.br.capacita.Controller


import com.br.capacita.Interfaces.LoginInterface
import com.br.capacita.Model.Login
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.Connection.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginController {
    fun login(user: UsuarioPCD): String {
        lateinit var message: String
        message = ""

        val responseUsuario = RetrofitClient.abrirConexao(LoginInterface::class.java)
        responseUsuario.login(user).enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                val teste = response.body()
                if (teste == null) {
                    message = "Email ou senha Inválido, tente novamente"

                } else {
                    user.token = response.body()!!.token
                    user.nome = response.body()!!.usuarioPCD.nome
                    user.email = response.body()!!.usuarioPCD.email
                    println(response.body())
                    message = "Login efetuado com sucesso"
                }
                println("${user.token} ${user.nome} ${user.email}")
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                println("ERRO >>>>>>>>>> ${t}")
            }

        })
        println("MENSAGEM >>>>>>>>>>>>>>" + message)
        return message
    }
}