package com.example.ertekler.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.ertekler.data.model.Story
import com.example.ertekler.data.model.StoryType

@Dao
interface StoriesDao{
    @Query ("SELECT * FROM story")
    fun getAllStories (): List<Story>

    @Query("SELECT * FROM story WHERE type =:typeId")
    fun getStoriesByType(typeId: Int): List<Story>

    @Query ("SELECT * FROM types")
    fun getAllTypes (): List<StoryType>
}