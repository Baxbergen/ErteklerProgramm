package com.example.ertekler.ui.stories

import com.example.ertekler.data.dao.StoriesDao

class StoryListPresenter(private val view: StoryListView, private val dao: StoriesDao) {

    fun getStoriesByTypeId(typeId:Int) {
        view.setStories(dao.getStoriesByType(typeId))
    }
}