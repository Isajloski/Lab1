package mk.finki.ukim.lab_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnExplicitActivity: Button
    private lateinit var btnImplicitActivity: Button
    private lateinit var btnIntentActionSend: Button
    private lateinit var btnSelectPhoto: Button
    private lateinit var TextView1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("Main Activity")

        //Иницијализација!
        btnExplicitActivity = findViewById(R.id.ExplicitActivity)
        btnImplicitActivity = findViewById(R.id.ImplicitActivity)
        btnIntentActionSend = findViewById(R.id.IntentActionSend)
        btnSelectPhoto = findViewById(R.id.SelectPhoto)
        TextView1 = findViewById(R.id.TextView1)



        btnExplicitActivity.setOnClickListener {
            Intent(this, ExplicitActivity::class.java).let { i ->
                i.putExtra("someData", "I was called by the Main Activity!")
                startActivity(i)
            }
        }

        btnImplicitActivity.setOnClickListener {
            Intent(this, ImplicitActivity::class.java).let { i ->
                i.putExtra("someData", "I was called by the Main Activity!")
                startActivity(i)
            }
        }

        btnSelectPhoto.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.setDataAndType(Uri.parse("file://" + "/sdcard/test.jpg"), "image/*")
            startActivity(intent)
        }

        btnIntentActionSend.setOnClickListener {
            val sendIntent: Intent = Intent(this, ImplicitActivity::class.java).apply {
                action = Intent.ACTION_SEND
                putExtra("someData", "MPiP Send Title")
                type = "text/plain"
            }

            startActivity(sendIntent)
        }

    }

    override fun onResume() {
        super.onResume()

        TextView1 = findViewById(R.id.TextView1)

        val bundle : Bundle? = intent.extras
        val something: String = bundle?.get("someData")?.toString() ?: "Hello World!"
        TextView1.setText(something)
    }
}