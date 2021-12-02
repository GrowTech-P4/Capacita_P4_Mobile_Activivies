package com.br.capacitap4mobile2.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.br.capacita.Controller.LoginController
import com.br.capacita.Model.Login
import com.br.capacita.Model.TipoDeficiencia
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.R

class LoginActivity : AppCompatActivity() {
    var user = UsuarioPCD(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "0",
        "",
        "",
        "",
        mutableListOf<TipoDeficiencia>(),
        ""
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        lateinit var botao: Button
        lateinit var email: EditText
        lateinit var senha: EditText
        lateinit var registreSe: TextView

        botao = findViewById(R.id.botaoEntrar)
        email = findViewById(R.id.formEmail)
        senha = findViewById(R.id.formSenha)



        botao.setOnClickListener {

             user.email = email.text.toString().trim()
             user.senha = senha.text.toString().trim()

            LoginController().login(user,this)

            Toast.makeText(this, "Login Efetuado com sucesso", Toast.LENGTH_LONG).show()
            val home = Intent(this, MainActivity::class.java)
            startActivity(home)
        }

        val cadastro = findViewById<TextView>(R.id.txtRegistreSe)
        cadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}