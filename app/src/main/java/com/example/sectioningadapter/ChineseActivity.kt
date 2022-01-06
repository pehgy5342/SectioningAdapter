package com.example.sectioningadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import org.zakariya.stickyheaders.StickyHeaderLayoutManager

class ChineseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinese)

        var type = intent.getStringExtra("ch")?.toInt()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val list = arrayListOf<Num>()
        val stickyHeaderLayoutManager = StickyHeaderLayoutManager()

        val alist = arrayListOf<Item>()
        alist.add(Item(5,"111"))
        alist.add(Item(5,"222"))
        alist.add(Item(5,"333"))
        alist.add(Item(5,"444"))
        alist.add(Item(6,"555"))
        alist.add(Item(6,"666"))
        alist.add(Item(6,"777"))

        list.add(Num(type!!, "中文標題", alist))


        val myAdapter = MyAdapter()
        myAdapter.sections = list

        recyclerView.apply {
            adapter = myAdapter
            layoutManager = stickyHeaderLayoutManager
        }
    }
}