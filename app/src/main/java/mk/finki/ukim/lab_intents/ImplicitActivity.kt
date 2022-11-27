package mk.finki.ukim.lab_intents

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ImplicitActivity : AppCompatActivity() {

    private lateinit var TextView1: TextView
    private lateinit var btnOk: Button
    private lateinit var otkazi: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        btnOk = findViewById(R.id.voRed)
        otkazi = findViewById(R.id.otkazi)
        TextView1 = findViewById(R.id.textView1)
        supportActionBar?.setTitle("Explicit Activity")


        btnOk.setOnClickListener {
            val bundle: Bundle? = intent.extras
            val age: String = bundle?.get("someData")?.toString() ?: "N/A"
            TextView1.setText(age)
        }

        otkazi.setOnClickListener {
            Intent(this, MainActivity::class.java).let { i ->
                i.putExtra("someData", "Откажано!")
                startActivity(i)
            }

        }


    }
}