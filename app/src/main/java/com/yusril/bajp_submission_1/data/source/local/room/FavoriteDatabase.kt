package com.yusril.bajp_submission_1.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.data.source.local.entity.TvShow

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): FavoriteDatabase {
            if (INSTANCE == null) {
                synchronized(FavoriteDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteDatabase::class.java,
                        "favorite"
                    ).build()
                }
            }
            return INSTANCE as FavoriteDatabase
        }
    }
}