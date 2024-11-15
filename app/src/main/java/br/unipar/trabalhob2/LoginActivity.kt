package br.unipar.trabalhob2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val inputNome: EditText = findViewById(R.id.input_evento)
        val inputSenha: EditText = findViewById(R.id.input_descricao)

        val btnEntrar: Button = findViewById(R.id.btn_entrar)
        val btnCadastrar: Button = findViewById(R.id.btn_cadastrar)

        // Configura o botão "Entrar"
        btnEntrar.setOnClickListener {
            val nome = inputNome.text.toString()
            val senha = inputSenha.text.toString()

            if (nome.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show()
            } else {
                // Se as credenciais estiverem corretas, navega para a HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        // Configura o botão "Cadastrar"
        btnCadastrar.setOnClickListener {
            // Navega para a tela de cadastro
            val intent = Intent(this, NewLoginActivity::class.java)
            startActivity(intent)
        }
    }
}
