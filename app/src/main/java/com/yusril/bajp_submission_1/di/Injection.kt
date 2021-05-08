package com.yusril.bajp_submission_1.di

import android.content.Context
import com.yusril.bajp_submission_1.data.source.MovieRepository
import com.yusril.bajp_submission_1.data.source.remote.RemoteRepository

object Injection {

    fun provideRepository(context: Context): MovieRepository {
        val remoteRepository = RemoteRepository.getInstance()

        return MovieRepository.getInstance(remoteRepository)
    }
}