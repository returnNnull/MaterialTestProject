package com.bam.materialtestproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var addButton: FloatingActionButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.floatingActionButton)

        addButton.setOnClickListener {
            goToEditActivity()
        }

        if (intent != null) {
            val name = intent.getStringExtra("name").toString()
            val country = intent.getStringExtra("country").toString()
            val year = intent.getIntExtra("year", 0)
            val color = intent.getStringExtra("color").toString()
            PhonesRepository.list.add(Phone(name, country, year, color))
        } else {
            Log.e("MY_LOG", "NULL")
        }


        val adapter = PhoneListAdapter(this, R.layout.phone_list_item, layoutInflater)
        adapter.addAll(PhonesRepository.list)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter

    }

    fun goToEditActivity() {
        val intent = Intent(this, EditActivity::class.java)
        startActivity(intent)
    }


}