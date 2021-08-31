package com.example.minhascores

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class ListViewAdapter(var context: Context, var collors: ArrayList<Collor>): BaseAdapter() {
    override fun getCount(): Int {
        return collors.size
    }

    override fun getItem(position: Int): Any {
        return collors[position]
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val color = this.collors[position]
        val row: View

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row = inflater.inflate(R.layout.row_layout, null)
        }else{
            row = convertView
        }

        val imageColor = row.findViewById<ImageView>(R.id.ivAdapterImageColor)
        val colorName = row.findViewById<TextView>(R.id.tvAdpaterColorName)
        val colorCode = row.findViewById<TextView>(R.id.tvAdpaterColorCode)

        imageColor.setColorFilter(Color.parseColor(color.toHex()))
        colorName.text = color.name
        colorCode.text = String.format("#%06X", (0xFFFFFF and color.code))

        return row
    }

    fun add (collor: Collor) {
        collors.add(collor)
        collors.sort()
        notifyDataSetChanged()
    }

    fun remove (collor: Collor) {
        collors.remove(collor)
        notifyDataSetChanged()
    }

    fun update() {
        collors.sort()
        notifyDataSetChanged()
    }
}