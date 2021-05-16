package com.yusril.bajp_submission_1.data.source

import androidx.lifecycle.LiveData
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.data.source.local.entity.TvShow

interface MovieDataSource {

    fun getMoviesCatalogue(): LiveData<List<MovieEntity>>

    fun getTvShowsCatalogue(): LiveData<List<TvShowEntity>>

    fun getDetailMovie(id: Int): LiveData<MovieEntity>

    fun getDetailTvShow(id: Int): LiveData<TvShowEntity>

    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    fun getFavoriteMovieById(id: Int): LiveData<List<MovieEntity>>

    fun insertFavoriteMovie(movie: MovieEntity)

    fun deleteFavoriteMovie(id: Int)

    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>>

    fun getFavoriteTvShowById(id: Int): LiveData<List<TvShowEntity>>

    fun insertFavoriteTvShow(tvShow: TvShowEntity)

    fun deleteFavoriteTvShow(id: Int)

}