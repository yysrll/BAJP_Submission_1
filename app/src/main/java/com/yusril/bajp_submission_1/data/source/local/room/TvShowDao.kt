package com.yusril.bajp_submission_1.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.data.source.local.entity.TvShow

@Dao
interface TvShowDao {
    @Query("SELECT * FROM TvShowEntity")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM TvShowEntity WHERE id = :id")
    fun getFavoriteTvShowById(id: Int) : LiveData<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteTvShow(tvShow: TvShowEntity) : Long

    @Query("Delete from TvShowEntity where id = :id")
    fun deleteFavoriteTvShow(id: Int) : Int
}