package br.unipar.trabalhob2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class ListarEventosActivity : AppCompatActivity() {

    private val eventos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listar_eventos)

        val cadastrarButton: Button = findViewById(R.id.btn_add_evento)

        cadastrarButton.setOnClickListener {
            val intent = Intent(this, CadastrarEventosActivity::class.java)
            startActivityForResult(intent, 1)
        }

        val backButton: Button = findViewById(R.id.btn_cadastrar_login)
        backButton.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val novoEvento = data?.getStringExtra("evento")
            if (novoEvento != null) {
                eventos.add(novoEvento)

                val listView: ListView = findViewById(R.id.list_view_eventos)
                val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventos)
                listView.adapter = adapter
            }
        }
    }
}

