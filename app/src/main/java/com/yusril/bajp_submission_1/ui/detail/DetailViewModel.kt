package com.yusril.bajp_submission_1.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    var id: Int = 0

    fun getDetailMovie(): LiveData<MovieEntity> = movieRepository.getDetailMovie(id)

    fun getDetailTvShow(): LiveData<TvShowEntity> = movieRepository.getDetailTvShow(id)

}