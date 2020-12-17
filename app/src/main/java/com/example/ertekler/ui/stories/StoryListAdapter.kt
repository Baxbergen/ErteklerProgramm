package com.example.ertekler.ui.stories

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ertekler.R
import com.example.ertekler.core.inflate
import com.example.ertekler.data.model.Story
import kotlinx.android.synthetic.main.item_story.view.*

class StoryListAdapter : RecyclerView.Adapter<StoryListAdapter.StoryListViewHolder>() {

    var models: List<Story> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryListViewHolder {
        val itemView : View = parent.inflate(R.layout.item_story)
        return StoryListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoryListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size

    inner class StoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Story) {
            itemView.storyName.text = model.storyName
        }
    }
}