package com.yusril.bajp_submission_1.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yusril.bajp_submission_1.BuildConfig.API_KEY
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.remote.response.MovieResponse
import com.yusril.bajp_submission_1.data.source.remote.response.TvShowResponse
import com.yusril.bajp_submission_1.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    private val apiClient = ApiConfig.getApiService()

    fun loadMoviesCatalogue(): LiveData<List<MovieEntity>> {
        EspressoIdlingResource.increment()
        val catalogue = MutableLiveData<List<MovieEntity>>()
        apiClient.getMoviesCatalogue(API_KEY).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { catalogue.postValue(it.results) }
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
        return catalogue
    }

    fun loadTvShowsCatalogue():LiveData<List<TvShowEntity>> {
        EspressoIdlingResource.increment()
        val catalogue = MutableLiveData<List<TvShowEntity>>()
        apiClient.getTvShowsCatalogue(API_KEY).enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { catalogue.postValue(it.results) }
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return catalogue
    }

    fun loadDetailMovie(id: Int): LiveData<MovieEntity> {
        EspressoIdlingResource.increment()
        val detailMovie = MutableLiveData<MovieEntity>()
        apiClient.getDetailMovie(id, API_KEY).enqueue(object : Callback<MovieEntity> {
            override fun onResponse(call: Call<MovieEntity>, response: Response<MovieEntity>) {

                if (response.isSuccessful) {
                    detailMovie.postValue(response.body())
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieEntity>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return detailMovie
    }

    fun loadDetailTvShow(id: Int): LiveData<TvShowEntity> {
        EspressoIdlingResource.increment()
        val detailTvShow = MutableLiveData<TvShowEntity>()
        val client = ApiConfig.getApiService().getDetailTvShow(id, API_KEY)
        client.enqueue(object : Callback<TvShowEntity> {
            override fun onResponse(call: Call<TvShowEntity>, response: Response<TvShowEntity>) {

                if (response.isSuccessful) {
                    detailTvShow.postValue(response.body())
                } else {
                    Log.d(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowEntity>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return detailTvShow
    }


    companion object {
        private const val TAG = "ApiMovie"

        fun getInstance(): RemoteRepository {
            return RemoteRepository()
        }
    }
}