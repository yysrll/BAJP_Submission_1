package com.yusril.bajp_submission_1.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity(
    @SerializedName("id")
    var id: Int,

    @SerializedName("original_name")
    var title: String,

    @SerializedName("overview")
    var summary: String,

    @SerializedName("first_air_date")
    var year: String,

    @SerializedName("vote_average")
    var score: Double,

    @SerializedName("original_language")
    var language: String,

    @SerializedName("poster_path")
    var poster: String
): Parcelable
