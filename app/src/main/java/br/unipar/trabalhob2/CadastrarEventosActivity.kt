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

class CadastrarEventosActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null
    private lateinit var imgEvento: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrar_eventos)

        val eventoInput: EditText = findViewById(R.id.input_evento)
        val descricaoInput: EditText = findViewById(R.id.input_descricao)
        val totalJogadoresInput: EditText = findViewById(R.id.input_total_jogadores)
        val dataEventoInput: EditText = findViewById(R.id.input_data_evento)
        val horaEventoInput: EditText = findViewById(R.id.input_hora_evento)
        val addImageButton: Button = findViewById(R.id.btn_add_image_evento)
        imgEvento = findViewById(R.id.img_evento)

        addImageButton.setOnClickListener {
            openGallery()
        }

        val addButton: Button = findViewById(R.id.btn_add_evento)

        addButton.setOnClickListener {
            val evento = eventoInput.text.toString()
            val descricao = descricaoInput.text.toString()
            val totalJogadores = totalJogadoresInput.text.toString()
            val dataEvento = dataEventoInput.text.toString()
            val horaEvento = horaEventoInput.text.toString()

            if (evento.isNotEmpty() && descricao.isNotEmpty() && totalJogadores.isNotEmpty() &&
                dataEvento.isNotEmpty() && horaEvento.isNotEmpty()) {

                val eventoCompleto = "Evento: $evento\nDescrição: $descricao\nTotal de Jogadores: $totalJogadores\nData: $dataEvento\nHora: $horaEvento"

                val resultIntent = Intent().apply {
                    putExtra("evento", eventoCompleto)
                }

                setResult(Activity.RESULT_OK, resultIntent)
                finish()

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        val backButton: Button = findViewById(R.id.btn_cadastrar_login)
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
                imgEvento.setImageBitmap(bitmap)
            }
        }
    }
}
