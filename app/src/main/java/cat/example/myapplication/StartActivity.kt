package cat.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class StartActivity : AppCompatActivity() {

    lateinit var missatge: TextView
    lateinit var inputNumero: EditText
    lateinit var botoEndevina: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // Vinculem els elements del layout
        missatge = findViewById(R.id.txtMissatge)
        inputNumero = findViewById(R.id.txtNumero)
        botoEndevina = findViewById(R.id.btnEndevina)

        // --- Recuperem el nom passat des de MainActivity ---
        val nomRebut = intent.getStringExtra("nom") ?: "Usuari"

        missatge.text = "Hola, $nomRebut! Endevina un número del 1 al 3:"

        // --- Número secret ---
        val numeroCorrecte = Random.nextInt(1, 4)

        // --- Quan prem el botó ---
        botoEndevina.setOnClickListener {
            val text = inputNumero.text.toString()

            if (text.isEmpty()) {
                inputNumero.error = "Introdueix un número"
                return@setOnClickListener
            }

            val numeroTriat = text.toIntOrNull()

            if (numeroTriat == null || numeroTriat !in 1..3) {
                inputNumero.error = "Només pots escriure 1, 2 o 3"
                return@setOnClickListener
            }

            val intent = if (numeroTriat == numeroCorrecte) {
                Intent(
                    this,
                    SuccessActivity::class.java
                ) //Si l’usuari encerta, es crea un Intent per obrir SuccessActivity
            } else {
                Intent(this, ErrorActivity::class.java) //Si falla, es crea un Intent per obrir ErrorActivity.
            }

            intent.putExtra("nom", nomRebut)
            intent.putExtra("numeroTriat", numeroTriat)
            intent.putExtra("numeroCorrecte", numeroCorrecte)
            startActivity(intent) // Aquesta línia inicia l’activitat corresponent (SuccessActivity o ErrorActivity) amb les dades
        }

        val botoTornar = findViewById<Button>(R.id.btnTornar)
        botoTornar.setOnClickListener {
            finish()
        }
    }
}