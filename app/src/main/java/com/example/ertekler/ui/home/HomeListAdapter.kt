package com.example.ertekler.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ertekler.R
import com.example.ertekler.data.model.Story
import com.example.ertekler.data.model.StoryType
import kotlinx.android.synthetic.main.item_home.view.*

class HomeListAdapter: RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    var models: List<StoryType> = listOf()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    private var onItemClick: (StoryType) -> Unit = {}
    fun setOnItemCLickListener(onItemClick: (StoryType) -> Unit) {
        this.onItemClick = onItemClick
    }

    inner class HomeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(storyType: StoryType){
            itemView.tvTheme.text = storyType.name
            val imageResName = "picture${storyType.id}"
            Glide
                .with(itemView)
                .load(itemView.context.resources.getIdentifier(imageResName,"drawable",itemView.context.packageName))
                .centerCrop()
                .into(itemView.ivTheme)
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