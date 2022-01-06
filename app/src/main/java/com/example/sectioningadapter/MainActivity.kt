package com.example.sectioningadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import org.zakariya.stickyheaders.StickyHeaderLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ch = findViewById<Button>(R.id.btn_ch)
        val en = findViewById<Button>(R.id.btn_en)

        ch.setOnClickListener {
            val intent = Intent(this, ChineseActivity::class.java)
            intent.putExtra("ch", "1")
            startActivity(intent)
        }
        en.setOnClickListener {
            val intent = Intent(this, EnglishActivity::class.java)
            intent.putExtra("en", "2")
            startActivity(intent)
        }

    }
}