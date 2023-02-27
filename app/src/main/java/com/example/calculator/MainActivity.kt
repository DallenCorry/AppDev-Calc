package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clear: Button = findViewById(R.id.btnClear)
        val txtField:TextView = findViewById(R.id.textView1)



        clear.setOnClickListener {
            txtField.text = ""
        }
    }
}