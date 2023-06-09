package com.example.teschallengechp5.di

import android.app.Application
import androidx.room.Room
import com.example.teschallengechp5.room.FavoritDao
import com.example.teschallengechp5.room.FavoritDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class HiltModule {
    @Singleton
    @Provides
    fun provideDatabase(app: Application):FavoritDatabase {
        return Room.databaseBuilder(app, FavoritDatabase::class.java, "favorite_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFavoriteDao(database:FavoritDatabase):FavoritDao {
        return database.favoritDao()
    }
}