package com.bam.materialtestproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.bam.materialtestproject.databinding.ActivityEditBinding
import com.google.android.material.textfield.TextInputLayout

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.button.setOnClickListener {
            val nameText = binding.nameEditText.editText?.text.toString()
            val country = binding.countryEditText.editText?.text.toString()
            val createText = binding.createYearEditText.editText?.text.toString()
            val color = binding.colorEditText.editText?.text.toString()
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


}