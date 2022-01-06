package com.example.sectioningadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import org.zakariya.stickyheaders.StickyHeaderLayoutManager

class EnglishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english)

        val type = intent.getStringExtra("en")?.toInt()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val list = arrayListOf<Num>()
        val stickyHeaderLayoutManager = StickyHeaderLayoutManager()

        val alist = arrayListOf<Item>()
        alist.add(Item(5,"AAA"))
        alist.add(Item(6,"BBB"))
        alist.add(Item(5,"CCC"))
        alist.add(Item(6,"DDD"))
        alist.add(Item(5,"EEE"))
        alist.add(Item(6,"FFF"))
        alist.add(Item(5,"GGG"))

        list.add(Num(type!!, "EnglishTitle", alist))

        val myAdapter = MyAdapter()
        myAdapter.sections = list

        recyclerView.apply {
            adapter = myAdapter
            layoutManager = stickyHeaderLayoutManager
        }
    }
}