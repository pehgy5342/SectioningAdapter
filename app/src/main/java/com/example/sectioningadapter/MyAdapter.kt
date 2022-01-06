package com.example.sectioningadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.zakariya.stickyheaders.SectioningAdapter

class MyAdapter : SectioningAdapter() {

    companion object{
        private const  val VIEW_TITLE = R.layout.item_title
        private const  val VIEW_LIST = R.layout.item_msg
        private const val VIEW_BUTTON = R.layout.item_button
    }

    var sections = ArrayList<Num>()

    override fun doesSectionHaveFooter(sectionIndex: Int): Boolean {
        return false
    }

    override fun doesSectionHaveHeader(sectionIndex: Int): Boolean {
        return true
    }

    override fun getNumberOfItemsInSection(sectionIndex: Int): Int {
        return sections[sectionIndex].items.size
    }

    override fun getNumberOfSections(): Int {
        return sections.size
    }


    override fun getSectionHeaderUserType(sectionIndex: Int): Int {
        return sections[sectionIndex].type
    }


    override fun onCreateHeaderViewHolder(parent: ViewGroup?, headerUserType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(VIEW_TITLE,parent,false)

        return when(headerUserType){
            1-> MyHeaderViewHolder.ChineseTitle(view)
            2-> MyHeaderViewHolder.EnglishTitle(view)
            else -> throw IllegalArgumentException("UnKnown : $headerUserType")
        }
    }

    override fun onBindHeaderViewHolder(viewHolder: HeaderViewHolder?, sectionIndex: Int, headerUserType: Int) {
        when(viewHolder){
            is MyHeaderViewHolder.ChineseTitle->{
                viewHolder.bind(sections[sectionIndex].header as String)
            }
            is MyHeaderViewHolder.EnglishTitle->{
                viewHolder.bind(sections[sectionIndex].header as String)
            }
        }
    }

    override fun getSectionItemUserType(sectionIndex: Int, itemIndex: Int): Int {
        return sections[sectionIndex].items[itemIndex].type
    }

    override fun onCreateItemViewHolder(parent: ViewGroup?, itemUserType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(VIEW_LIST,parent,false)
        val view2 = LayoutInflater.from(parent?.context).inflate(VIEW_BUTTON,parent,false)
        return when(itemUserType){
            5 -> MyListViewHolder.MyMessage(view)
            6 -> MyListViewHolder.MyButton(view2)
            else -> throw IllegalArgumentException("UnKnown$itemUserType")
        }
    }

    override fun onBindItemViewHolder(viewHolder: ItemViewHolder?, sectionIndex: Int, itemIndex: Int, itemUserType: Int) {
        when(viewHolder){
            is MyListViewHolder.MyMessage ->{
                viewHolder.bind(sections[sectionIndex].items[itemIndex].items as String)
            }
            is MyListViewHolder.MyButton ->{
                viewHolder.bind(sections[sectionIndex].items[itemIndex].items as String)
            }
        }
    }

    sealed class MyHeaderViewHolder(itemView:View) : SectioningAdapter.HeaderViewHolder(itemView){
        class ChineseTitle (itemView:View):MyHeaderViewHolder(itemView){
            fun bind(title:String){
               val t = itemView.findViewById<TextView>(R.id.txt_title)
                t.text = title
            }
        }
        class EnglishTitle (itemView:View):MyHeaderViewHolder(itemView){
            fun bind(title:String){
                val t = itemView.findViewById<TextView>(R.id.txt_title)
                t.text = title
            }
        }
    }

    sealed class MyListViewHolder(itemView: View) : SectioningAdapter.ItemViewHolder(itemView){
        class MyMessage(itemView: View):MyListViewHolder(itemView){
            fun bind(msg:String){
                val m = itemView.findViewById<TextView>(R.id.txt_msg)
                m.text = msg
            }
        }
        class MyButton(itemView: View):MyListViewHolder(itemView){
            fun bind(button:String){
                val b = itemView.findViewById<Button>(R.id.btn_1)
                b.text = button
            }
        }
    }
}

