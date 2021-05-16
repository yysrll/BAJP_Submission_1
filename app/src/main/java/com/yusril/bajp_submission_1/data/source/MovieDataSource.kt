package com.yusril.bajp_submission_1.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity

interface MovieDataSource {

    fun getMoviesCatalogue(): LiveData<List<MovieEntity>>

    fun getTvShowsCatalogue(): LiveData<List<TvShowEntity>>

    fun getDetailMovie(id: Int): LiveData<MovieEntity>

    fun getDetailTvShow(id: Int): LiveData<TvShowEntity>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteMovieById(id: Int): LiveData<List<MovieEntity>>

    fun insertFavoriteMovie(movie: MovieEntity)

    fun deleteFavoriteMovie(id: Int)

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun getFavoriteTvShowById(id: Int): LiveData<List<TvShowEntity>>

    fun insertFavoriteTvShow(tvShow: TvShowEntity)

    fun deleteFavoriteTvShow(id: Int)

}