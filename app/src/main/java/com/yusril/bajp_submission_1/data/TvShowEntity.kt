package com.yusril.bajp_submission_1.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class TvShowEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @ColumnInfo
    var id: Int,

    @SerializedName("original_name")
    @ColumnInfo
    var title: String,

    @SerializedName("overview")
    @ColumnInfo
    var summary: String,

    @SerializedName("first_air_date")
    @ColumnInfo
    var year: String,

    @SerializedName("vote_average")
    @ColumnInfo
    var score: Double,

    @SerializedName("original_language")
    @ColumnInfo
    var language: String,

    @SerializedName("poster_path")
    @ColumnInfo
    var poster: String
) : Parcelable
