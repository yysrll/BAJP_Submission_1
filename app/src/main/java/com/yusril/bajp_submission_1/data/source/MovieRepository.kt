package com.yusril.bajp_submission_1.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.remote.RemoteRepository

class MovieRepository private constructor(private val remoteRepository: RemoteRepository) :
    MovieDataSource {


    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteRepository: RemoteRepository): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteRepository).apply {
                    instance = this
                }
            }
    }

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