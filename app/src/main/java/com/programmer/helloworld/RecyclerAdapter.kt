package com.programmer.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    //Image list
    private val images = intArrayOf(
        R.drawable.cardview_1,
        R.drawable.cardview_2,
        R.drawable.cardview_3,
        R.drawable.cardview_4,
        R.drawable.cardview_5,
        R.drawable.cardview_6)
    //Title list
    private val titles = arrayOf(
        "1 Hello World",
        "2 Game Pertama",
        "3 Activity onCreate()",
        "4 Membuat Background",
        "5 Menggunakan TextView",
        "6 Menggunakan Button")
    //Detail list
    private val details = arrayOf(
        "Aplikasi pertama belajar programming",
        "Mudah membuat game Android",
        "Hal mendasar dan sangat penting dipahami",
        "Agar tampilan App dan Game beda & menarik",
        "Komponen UI dasar Androin App dan Game",
        "Komponen UI dasar Androin App dan Game")
    //ViewHolder class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init{
            itemImage = itemView.findViewById(R.id.cardImage)
            itemTitle = itemView.findViewById(R.id.cardTitle)
            itemDetail = itemView.findViewById(R.id.cardDetail)
            //snackbar
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Anda memencet ${titles[position]}",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }

    }

    //onCreateViewHolder()
    //untuk menentukan berapa card layout dibuat
    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(ViewGroup.context)
            .inflate(R.layout.card_layout, ViewGroup, false)
        return ViewHolder(v)
    }
    //onBindViewHolder()
    //masukan data sesuai view holder
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
    //getItemCount()
    //untuk mengetahui banyaknya set data
    override fun getItemCount(): Int {
        return titles.size
    }
}