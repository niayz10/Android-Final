package com.example.afinal.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R
import com.example.afinal.models.Country
import com.squareup.picasso.Picasso


class StatisticsList(var item: Country, var context: Context?): RecyclerView.Adapter<StatisticsList.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(item, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: News = item.news[position]
        holder.id = position
        holder.title.text = item.title
        holder.author.text = item.author
        Picasso.get().load(item.urlToImage.toString())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return item.news.size
    }

    class ViewHolder(var item: Country, view: View): RecyclerView.ViewHolder(view){
        var id: Int = -1
        private var content: ConstraintLayout = view.findViewById(R.id.content)
        var title: TextView = view.findViewById(R.id.news_title)
        var author: TextView = view.findViewById(R.id.news_author)
        var image: ImageView = view.findViewById(R.id.image)

        init {

        }
    }
}