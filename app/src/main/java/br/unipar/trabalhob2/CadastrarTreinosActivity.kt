package br.unipar.trabalhob2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastrarTreinosActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null
    private lateinit var imgTreino: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrar_treinos)

        val treinoInput: EditText = findViewById(R.id.input_treinos)
        val descricaoInput: EditText = findViewById(R.id.input_descricao)
        val totalJogadoresInput: EditText = findViewById(R.id.input_total_jogadores)
        val dataEventoInput: EditText = findViewById(R.id.input_data_evento)
        val horaEventoInput: EditText = findViewById(R.id.input_hora_evento)
        val addButton: Button = findViewById(R.id.btn_add_evento)
        val backButton: Button = findViewById(R.id.btn_cadastrar_login)
        val addImageButton: Button = findViewById(R.id.btn_add_image_treino)
        imgTreino = findViewById(R.id.img_treino)

        addImageButton.setOnClickListener {
            openGallery()
        }

        addButton.setOnClickListener {
            val treino = treinoInput.text.toString()
            val descricao = descricaoInput.text.toString()
            val totalJogadores = totalJogadoresInput.text.toString()
            val dataEvento = dataEventoInput.text.toString()
            val horaEvento = horaEventoInput.text.toString()

            if (treino.isNotEmpty() && descricao.isNotEmpty() && totalJogadores.isNotEmpty() &&
                dataEvento.isNotEmpty() && horaEvento.isNotEmpty()) {

                val treinoCompleto =
                    "Treino: $treino\nDescrição: $descricao\nTotal de Jogadores: $totalJogadores\nData: $dataEvento\nHora: $horaEvento"

                val resultIntent = Intent().apply {
                    putExtra("treino", treinoCompleto)
                }

                setResult(Activity.RESULT_OK, resultIntent)
                finish()

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun openGallery() {

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST) {
            selectedImageUri = data?.data
            selectedImageUri?.let {
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, it)
                imgTreino.setImageBitmap(bitmap)
            }
        }
    }
}
