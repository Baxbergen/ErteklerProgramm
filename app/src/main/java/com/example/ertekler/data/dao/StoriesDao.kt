package com.example.ertekler.data.dao

import android.content.Context
import androidx.room.Dao
import androidx.room.Query
import com.example.ertekler.data.model.Story
import com.example.ertekler.data.model.StoryType

@Dao
interface StoriesDao{
    @Query ("SELECT * FROM stories")
    fun getAllStories (): List<Story>

    @Query("SELECT * FROM stories WHERE type =:typeId")
    fun getStoriesByType(typeId: Int): List<Story>

    @Query ("SELECT * FROM types")
    fun getAllTypes (): List<StoryType>

    @Query ("SELECT * FROM stories WHERE id =:id")
    fun getStoryById(id: Int): Story
}