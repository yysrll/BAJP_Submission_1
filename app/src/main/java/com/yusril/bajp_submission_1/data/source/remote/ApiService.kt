package com.yusril.bajp_submission_1.data.source.remote

import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity
import com.yusril.bajp_submission_1.data.source.remote.response.MovieResponse
import com.yusril.bajp_submission_1.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMoviesCatalogue(
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShowsCatalogue(
        @Query("api_key") apiKey: String
    ): Call<TvShowResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<MovieEntity>

    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<TvShowEntity>
}