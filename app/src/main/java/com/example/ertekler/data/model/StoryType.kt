package com.example.ertekler.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "types")
data class StoryType (
    @PrimaryKey val id: Int,

    @ColumnInfo (name = "name")
    val name: String
)