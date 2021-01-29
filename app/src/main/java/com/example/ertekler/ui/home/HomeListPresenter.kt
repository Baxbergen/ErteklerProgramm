package com.example.ertekler.ui.home

import com.example.ertekler.data.dao.StoriesDao

class HomeListPresenter(private val view : HomeListView, private  val dao : StoriesDao) {
    fun getData() {
        view.setData(dao.getAllTypes())
    }
}