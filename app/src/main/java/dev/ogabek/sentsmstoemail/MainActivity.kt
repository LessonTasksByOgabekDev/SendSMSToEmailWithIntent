package dev.ogabek.sentsmstoemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var to: EditText
    private lateinit var message: EditText
    private lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        title = findViewById(R.id.et_title)
        to  = findViewById(R.id.et_to)
        message = findViewById(R.id.et_message)
        send = findViewById(R.id.btn_send)

        send.setOnClickListener {
            sentMessage(title.text.toString(), to.text.toString(), message.text.toString())
        }
    }

    private fun sentMessage(title: String, to: String, message: String) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, to)
        intent.putExtra(Intent.EXTRA_SUBJECT, title)
        intent.putExtra(Intent.EXTRA_TEXT, message)

        startActivity(Intent.createChooser(intent, "Send Email"))

    }

}