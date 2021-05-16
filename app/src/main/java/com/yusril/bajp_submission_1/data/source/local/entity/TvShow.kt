package com.yusril.bajp_submission_1.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class TvShow(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    var id: Int,

    @ColumnInfo
    var title: String,

    @ColumnInfo
    var summary: String,

    @ColumnInfo
    var year: String,

    @ColumnInfo
    var score: Double,

    @ColumnInfo
    var language: String,

    @ColumnInfo
    var poster: String
) : Parcelable