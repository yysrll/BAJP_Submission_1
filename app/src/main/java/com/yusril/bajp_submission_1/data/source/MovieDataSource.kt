package com.yusril.bajp_submission_1.data.source

import androidx.lifecycle.LiveData
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity

interface MovieDataSource {

    fun getMoviesCatalogue(): LiveData<List<MovieEntity>>

    fun getTvShowsCatalogue(): LiveData<List<TvShowEntity>>

    fun getDetailMovie(id: Int): LiveData<MovieEntity>

    fun getDetailTvShow(id: Int): LiveData<TvShowEntity>
}