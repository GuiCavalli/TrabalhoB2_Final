package br.unipar.trabalhob2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val registerButton: Button = findViewById(R.id.btn_entrar)

        val viewEventsButton: Button = findViewById(R.id.btn_cadastrar)

        registerButton.setOnClickListener {
            val intent = Intent(this, ListarTreinosActivity::class.java)
            startActivity(intent)
        }

        viewEventsButton.setOnClickListener {
            val intent = Intent(this, ListarEventosActivity::class.java)
            startActivity(intent)
        }

    }
}