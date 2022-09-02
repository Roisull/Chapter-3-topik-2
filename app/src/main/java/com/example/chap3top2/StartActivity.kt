package com.example.chap3top2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.chap3top2.DataClasses.Person

class StartActivity : AppCompatActivity() {

    lateinit var etData1: EditText
    lateinit var etData2: EditText
    lateinit var btnIntent: Button
    lateinit var btnBundle: Button
    lateinit var btnSerializable: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        etData1 = findViewById(R.id.et_input_data_satu)
        etData2 = findViewById(R.id.et_input_data_dua)
        btnIntent = findViewById(R.id.btn_pass_with_intent)
        btnBundle = findViewById(R.id.btn_pass_with_bundle)
        btnSerializable = findViewById(R.id.btn_pass_with_serializable)


        // action button with passing data for intent
        btnIntent.setOnClickListener {

            val intent = Intent(this, EndActivity::class.java)

            intent.putExtra("data1", etData1.text.toString())
            intent.putExtra("data2", etData2.text.toString())

            startActivity(intent)


        }

        // action button with passing data for Bundle
        btnBundle.setOnClickListener {

            val bundle = Bundle()

            bundle.putString("data1",etData1.text.toString())
            bundle.putString("data2",etData2.text.toString())

            val intent = Intent(this, EndActivity::class.java)
            intent.putExtras(bundle)

            startActivity(intent)


        }

        // action button with passing data for serializable
        btnSerializable.setOnClickListener {

            val intent = Intent(this, EndActivity::class.java)

            var person = Person(etData1.toString(), etData2.toString())

            intent.putExtra("AN_OBJECT", person)
            startActivity(intent)

        }

    }
}