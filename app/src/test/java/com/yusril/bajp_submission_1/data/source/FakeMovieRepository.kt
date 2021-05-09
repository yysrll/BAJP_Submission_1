package com.yusril.bajp_submission_1.data.source

import androidx.lifecycle.LiveData
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.remote.RemoteRepository

class FakeMovieRepository(private val remoteRepository: RemoteRepository) :
    MovieDataSource {


    override fun getMoviesCatalogue(): LiveData<List<MovieEntity>> {
        return remoteRepository.loadMoviesCatalogue()
    }

    override fun getTvShowsCatalogue(): LiveData<List<TvShowEntity>> {
        return remoteRepository.loadTvShowsCatalogue()
    }

    override fun getDetailMovie(id: Int): LiveData<MovieEntity> {
        return remoteRepository.loadDetailMovie(id)
    }

    override fun getDetailTvShow(id: Int): LiveData<TvShowEntity> {
        return remoteRepository.loadDetailTvShow(id)
    }
}