package com.example.ertekler.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.ertekler.data.model.Stories
import com.example.ertekler.data.model.Types

@Dao
interface StoriesDao{
    @Query ("SELECT * FROM story")
    fun getAllStories (): List<Stories>

    @Query("SELECT * FROM story WHERE type =:typeId")
    fun getStoriesByType(typeId: Int): List<Stories>

    @Query ("SELECT * FROM types")
    fun getAllTypes (): List<Types>
}