package com.yusril.bajp_submission_1.ui.movie

import androidx.lifecycle.ViewModel
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()

    fun getTvShows(): List<MovieEntity> = DataDummy.generateDummyTvShow()

}