package com.example.chap3top2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.chap3top2.DataClasses.Person
import org.w3c.dom.Text

class EndActivity : AppCompatActivity() {

    lateinit var tvGetData1: TextView
    lateinit var tvGetData2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        tvGetData1 = findViewById(R.id.tv_get_data_satu)
        tvGetData2 = findViewById(R.id.tv_get_data_dua)

        if (intent.extras != null){ // menerima data dari tombol bundle

            val bundle = intent.extras
            tvGetData1.setText(bundle?.getString("data1"))
            tvGetData2.setText(bundle?.getString("data2"))

        }else{ // menerima data dari tombol intent

            tvGetData1.setText(intent.getStringExtra("data1"))
            tvGetData2.setText(intent.getStringExtra("data2"))

        }

        // menerima data dari tombol serializable
        val person = intent.getSerializableExtra("AN_OBJECT") as Person

        tvGetData1.text = person.name
        tvGetData2.text = person.email

    }
}