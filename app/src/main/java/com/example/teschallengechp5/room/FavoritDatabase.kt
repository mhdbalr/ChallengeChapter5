package com.example.teschallengechp5.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavoritNote::class],
    version = 2
)

abstract class FavoritDatabase : RoomDatabase() {

    abstract fun favoritDao() : FavoritDao

}