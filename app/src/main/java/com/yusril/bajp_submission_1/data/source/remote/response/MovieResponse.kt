package com.yusril.bajp_submission_1.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.yusril.bajp_submission_1.data.MovieEntity

data class MovieResponse(

    @SerializedName("results")
    val results: MutableList<MovieEntity>

)