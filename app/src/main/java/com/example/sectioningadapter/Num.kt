package com.example.sectioningadapter

data class Num(val type:Int,val header:Any,val items:ArrayList<Item>)

data class Item(val type:Int,val items:Any?)
