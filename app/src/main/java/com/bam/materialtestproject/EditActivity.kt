package com.bam.materialtestproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class EditActivity : AppCompatActivity() {

    lateinit var name: TextInputLayout
    lateinit var country: TextInputLayout
    lateinit var createYear: TextInputLayout
    lateinit var color: TextInputLayout
    lateinit var createBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        initViews()

        createBtn.setOnClickListener {
            val nameText = name.editText?.text.toString()
            val country = country.editText?.text.toString()
            val createText = createYear.editText?.text.toString()
            val color = color.editText?.text.toString()
            val phone = Phone(nameText, country, createText.toInt(), color)
            goToMainActivity(phone)
        }

    }


    fun goToMainActivity(phone: Phone){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", phone.name)
        intent.putExtra("country", phone.country)
        intent.putExtra("year", phone.createYear)
        intent.putExtra("color", phone.color)
        startActivity(intent)
    }


    private fun initViews() {
       name = findViewById(R.id.nameEditText)
        country = findViewById(R.id.countryEditText)
        createYear = findViewById(R.id.createYearEditText)
        color = findViewById(R.id.colorEditText)
        createBtn = findViewById(R.id.button)
    }
}