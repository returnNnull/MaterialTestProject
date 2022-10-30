package com.bam.materialtestproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bam.materialtestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            goToEditActivity(-1)
        }


        PhonesRepository.initList()
        val adapter = PhoneListAdapter(PhonesRepository.getAllPhones())
        adapter.listener {
            goToEditActivity(it)
        }
        binding.phoneList.adapter = adapter

    }

    private fun goToEditActivity(position: Int) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("id", position)
        startActivity(intent)
    }


}