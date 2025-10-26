package cat.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val nom = intent.getStringExtra("nom")
        val numeroTriat = intent.getIntExtra("numeroTriat", -1)
        val numeroCorrecte = intent.getIntExtra("numeroCorrecte", -1)

        val resultat = findViewById<TextView>(R.id.txtResultatError)
        resultat.text = "Llàstima, $nom!\nHas triat el $numeroTriat però el correcte era el $numeroCorrecte."

        val botoTornar = findViewById<Button>(R.id.btnTornar)
        botoTornar.setOnClickListener {
            finish()
        }
    }
}

