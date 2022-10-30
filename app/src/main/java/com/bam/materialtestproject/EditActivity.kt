package com.bam.materialtestproject

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bam.materialtestproject.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.extras != null) {
            val id = intent.getIntExtra("id", 0)
            if (id != -1) {
                binding.deleteBtn.visibility = View.VISIBLE

                binding.deleteBtn.setOnClickListener {
                    PhonesRepository.deletePhone(id)
                    goToMainActivity()
                }

                binding.phone = PhonesRepository.getPhoneById(id)
                binding.button.setOnClickListener {
                    PhonesRepository.updatePhone(id, initPhone())
                    goToMainActivity()
                }
            }
            else {
                binding.button.setOnClickListener {
                    PhonesRepository.insertPhone(initPhone())
                    goToMainActivity()
                }
            }
        }

    }


    private fun initPhone(): Phone {
        val nameText = binding.nameEditText.editText?.text.toString()
        val country = binding.countryEditText.editText?.text.toString()
        val createText = binding.createYearEditText.editText?.text.toString()
        val color = binding.colorEditText.editText?.text.toString()

        return Phone(nameText, country, createText.toInt(), color)
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}