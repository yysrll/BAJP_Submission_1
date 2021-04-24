package com.yusril.bajp_submission_1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    var id: String,
    var title: String,
    var summary: String,
    var year: Int,
    var score: Int,
    var duration: String,
    var language: String,
    var poster: Int
) : Parcelable