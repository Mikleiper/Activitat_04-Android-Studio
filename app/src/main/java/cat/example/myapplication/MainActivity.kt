package cat.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var botoinici: Button //per a que pugui ser null
    lateinit var nomTxt: EditText // camp on s'escriu el nom
    lateinit var dataActual: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Associem aquest main amb el seu layout xml

        // --- Vinculem els elements del XML amb les variables ---
        botoinici = findViewById<Button>(R.id.btninici)
        nomTxt = findViewById<EditText>(R.id.nm)
        dataActual = findViewById<TextView>(R.id.data)

        //data actual
        val data = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        dataActual.text = "Avui és $data" // Es mostra en el TextView amb el format: "Avui és 17/10/2025"

        botoinici.setOnClickListener {
            val nom = nomTxt.text.toString() //Obtenim el text escrit per l'usuari
            //verifiquem que el camp no està buit
            if (nom.isNotEmpty()) { //creem un intent que és un objecte q android utilitza per comunicar componenets entre sí
                val intent = Intent(/* packageContext = */ this, /* cls = */ StartActivity::class.java) // this és el context actual, startactivityy:: és l'activitat que vole obrir
                intent.putExtra("nom", nom) //enviem el nom
                startActivity(intent) // iniciem stratActivity amb el nom
            } else {
                nomTxt.error = "Introdueix el teu nom"
            }
        }
    }
}