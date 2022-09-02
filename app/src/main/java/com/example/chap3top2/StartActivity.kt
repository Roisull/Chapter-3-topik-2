package com.example.chap3top2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import com.example.chap3top2.DataClasses.Argument
import com.example.chap3top2.DataClasses.Person

class StartActivity : AppCompatActivity() {

    lateinit var etData1: EditText
    lateinit var etData2: EditText
    lateinit var btnIntent: Button
    lateinit var btnBundle: Button
    lateinit var btnSerializable: Button
    lateinit var btnOpenGaleri: Button
    lateinit var btnOpenCamera: Button
    lateinit var btnOpenWeb: Button
    lateinit var btnParcelable: Button

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        etData1 = findViewById(R.id.et_input_data_satu)
        etData2 = findViewById(R.id.et_input_data_dua)
        btnIntent = findViewById(R.id.btn_pass_with_intent)
        btnBundle = findViewById(R.id.btn_pass_with_bundle)
        btnSerializable = findViewById(R.id.btn_pass_with_serializable)
        btnOpenGaleri = findViewById(R.id.btn_open_galeri)
        btnOpenCamera = findViewById(R.id.btn_open_camera)
        btnOpenWeb = findViewById(R.id.btn_open_web)
        btnParcelable = findViewById(R.id.btn_parcelable)


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

            var person = Person("$etData1", "$etData2")

            intent.putExtra("AN_OBJECT", person)
            startActivity(intent)

        }

        // action button with open galeri
        btnOpenGaleri.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/"
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }

        // action button with open camera
        btnOpenCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // action button with open web
        btnOpenWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://developer.android.com/codelabs/android-training-activity-with-implicit-intent?index=..%2F..%2Fandroid-training#4")
            startActivity(intent)
        }

        // action button with parcellable
        btnParcelable.setOnClickListener {
            val intent = Intent(this, EndActivity::class.java)
            val data = Argument("$etData1","$etData2")
            intent.putExtra("dataArgument", data)
            startActivity(intent)
        }


    }
}