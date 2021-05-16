package com.yusril.bajp_submission_1.data.source.local

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.data.source.local.entity.TvShow
import com.yusril.bajp_submission_1.data.source.local.room.FavoriteDatabase
import com.yusril.bajp_submission_1.data.source.local.room.MovieDao
import com.yusril.bajp_submission_1.data.source.local.room.TvShowDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LocalRepository(context: Context) {
    private val movieDao: MovieDao
    private val tvShowDao: TvShowDao

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
    val db = FavoriteDatabase.getDatabase(context)
        movieDao = db.movieDao()
        tvShowDao = db.tvShowDao()
    }

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovie()

    fun getFavoriteMovieById(id: Int): LiveData<List<MovieEntity>> = movieDao.getFavoriteMovieById(id)

    fun insertFavoriteMovie(movie: MovieEntity) = executorService.execute { movieDao.insertFavoriteMovie(movie) }

    fun deleteFavoriteMovie(id: Int) = executorService.execute { movieDao.deleteFavoriteMovie(id) }

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = tvShowDao.getFavoriteTvShow()

    fun getFavoriteTvShowById(id: Int): LiveData<List<TvShowEntity>> = tvShowDao.getFavoriteTvShowById(id)

    fun insertFavoriteTvShow(tvShow: TvShowEntity) = executorService.execute { tvShowDao.insertFavoriteTvShow(tvShow) }

    fun deleteFavoriteTvShow(id: Int) = executorService.execute { tvShowDao.deleteFavoriteTvShow(id) }

    companion object {
        private var INSTANCE: LocalRepository? = null

        fun getInstance(context: Context): LocalRepository =
            INSTANCE ?: LocalRepository(context)
    }
}