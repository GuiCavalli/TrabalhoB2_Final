package br.unipar.trabalhob2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListarTreinosActivity : AppCompatActivity() {

    private val treinos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listar_treinos)

        val cadastrarButton: Button = findViewById(R.id.btn_add_evento)
        cadastrarButton.setOnClickListener {
            val intent = Intent(this, CadastrarTreinosActivity::class.java)
            startActivityForResult(intent, 1)
        }

        val backButton: Button = findViewById(R.id.btn_cadastrar_login)
        backButton.setOnClickListener {
            finish()
        }

        val listView: ListView = findViewById(R.id.list_view_treinos)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, treinos)
        listView.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val novoTreino = data?.getStringExtra("treino")
            if (novoTreino != null) {
                treinos.add(novoTreino)
                val listView: ListView = findViewById(R.id.list_view_treinos)
                val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, treinos)
                listView.adapter = adapter
            }
        }
    }
}
