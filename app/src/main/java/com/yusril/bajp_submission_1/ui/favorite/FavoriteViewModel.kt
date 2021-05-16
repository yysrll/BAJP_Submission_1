package com.yusril.bajp_submission_1.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.MovieRepository
import com.yusril.bajp_submission_1.data.source.local.entity.Movie
import com.yusril.bajp_submission_1.data.source.local.entity.TvShow

class FavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getFavoriteMovies(): LiveData<List<MovieEntity>> = movieRepository.getFavoriteMovie()

    fun getFavoriteMovieById(id: Int): LiveData<List<MovieEntity>> = movieRepository.getFavoriteMovieById(id)

    fun insertFavoriteMovie(movie: MovieEntity) = movieRepository.insertFavoriteMovie(movie)

    fun deleteFavoriteMovie(id: Int) = movieRepository.deleteFavoriteMovie(id)

    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>> = movieRepository.getFavoriteTvShow()

    fun getFavoriteTvShowById(id: Int): LiveData<List<TvShowEntity>> = movieRepository.getFavoriteTvShowById(id)

    fun insertFavoriteTvShow(tvShow: TvShowEntity) = movieRepository.insertFavoriteTvShow(tvShow)

    fun deleteFavoriteTvShow(id: Int) = movieRepository.deleteFavoriteTvShow(id)
}