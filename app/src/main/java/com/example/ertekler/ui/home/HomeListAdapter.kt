package com.example.ertekler.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ertekler.R
import com.example.ertekler.data.model.Types
import kotlinx.android.synthetic.main.item_home.view.*

class HomeListAdapter: RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    var models: List<Types> = listOf()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    inner class HomeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(story: Types){
            itemView.tvTheme.text = story.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size
}