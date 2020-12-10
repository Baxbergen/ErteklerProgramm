package com.example.ertekler.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ertekler.data.dao.StoriesDao
import com.example.ertekler.data.model.Stories
import com.example.ertekler.data.model.Types

@Database (entities = [Stories::class, Types::class],  version = 1)
abstract class  StoriesDatabase : RoomDatabase(){
    companion object {
        private lateinit var INSTANCE: StoriesDatabase

        fun getInstance (context: Context):StoriesDatabase = Room.databaseBuilder(
            context,
            StoriesDatabase::class.java,
            "baza.db"
        )
        .createFromAsset("baza.db")
        .allowMainThreadQueries()
        .build()
    }
    abstract  fun dao() : StoriesDao
}