package com.yusril.bajp_submission_1.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getMoviesCatalogue()

    fun getTvShows(): LiveData<List<TvShowEntity>> = movieRepository.getTvShowsCatalogue()

}