package com.example.ertekler.ui.home

import com.example.ertekler.data.model.StoryType


interface HomeListView {
    fun setData (storyType: List<StoryType>)
}