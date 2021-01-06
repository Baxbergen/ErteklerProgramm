package com.example.ertekler.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "stories")
data class Story (
    @PrimaryKey val id: Int,

    @ColumnInfo (name = "story_name")
    val storyName:String,

    @ColumnInfo (name = "content")
    val content:String,

    @ColumnInfo(name = "type")
    val type:Int,
)