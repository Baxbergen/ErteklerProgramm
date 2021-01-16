package com.example.ertekler.ui.fullStories

import com.example.ertekler.data.dao.StoriesDao

class FullStoryPresenter(private val view: FullStoryView, private val dao: StoriesDao) {
    fun getContent(id: Int) {
        view.setContent(dao.getStoryById(id).content)
    }
}