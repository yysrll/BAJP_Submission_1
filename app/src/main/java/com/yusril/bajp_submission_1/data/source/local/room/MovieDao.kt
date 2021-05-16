package com.yusril.bajp_submission_1.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    fun getFavoriteMovieById(id: Int) : LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteMovie(movie: MovieEntity) : Long

    @Query("Delete from MovieEntity where id = :id")
    fun deleteFavoriteMovie(id: Int) : Int

}