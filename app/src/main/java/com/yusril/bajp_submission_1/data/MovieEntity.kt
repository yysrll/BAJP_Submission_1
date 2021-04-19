package com.yusril.bajp_submission_1.data

import android.graphics.drawable.Drawable

data class MovieEntity(
    var title: String,
    var summary: String,
    var year: Int,
    var score: Int,
    var duration: String,
    var language: String,
    var poster: Int
)