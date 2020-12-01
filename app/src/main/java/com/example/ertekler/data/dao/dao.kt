package com.example.ertekler.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.ertekler.data.model.Stories

@Dao
interface StoriesDao{
    @Query ("SELECT * FROM Story")
    fun getAllStories (): List<Stories>
}