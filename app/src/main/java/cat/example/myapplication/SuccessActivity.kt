package cat.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val nom = intent.getStringExtra("nom")
        val inputNumero = intent.getIntExtra("numeroTriat", -1)
        val numeroCorrecte = intent.getIntExtra("numeroCorrecte", -1)

        val resultat = findViewById<TextView>(R.id.txtResultat)
        resultat.text =
            "Bravo!, $nom!\nHas triat el número $inputNumero i era el número secret!."

        val botoTornar = findViewById<Button>(R.id.btnTornar)
        botoTornar.setOnClickListener {
            finish()
        }
    }
}