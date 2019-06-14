package com.example.samplemvvmcleanarch.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.samplemvvmcleanarch.domin.models.MovieEntity

/**
 * Room Database Manager.
 */

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        fun getInstance(context: Context): DatabaseManager {
            return Room.databaseBuilder(context.applicationContext,
                    DatabaseManager::class.java, "movie.db")
                    .build()
        }

    }
}