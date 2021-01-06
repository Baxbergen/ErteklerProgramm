package com.example.ertekler.ui.stories

import com.example.ertekler.data.model.Story

interface StoryListView {
    fun setStories(stories: List<Story>)
}