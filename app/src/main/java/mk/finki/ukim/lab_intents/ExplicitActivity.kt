package mk.finki.ukim.lab_intents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ExplicitActivity : AppCompatActivity() {

    private lateinit var TextView1 : TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)


        TextView1 = findViewById(R.id.textView1)
        supportActionBar?.setTitle("Explicit Activity")


            val bundle : Bundle? = intent.extras
            val age: String = bundle?.get("someData")?.toString() ?: "N/A"
            TextView1.setText(age)





    }
}