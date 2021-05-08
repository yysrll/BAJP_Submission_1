package com.yusril.bajp_submission_1.utils

import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.data.MovieEntity
import com.yusril.bajp_submission_1.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                1,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019",
                72.0,
                "English",
                R.drawable.poster_alita.toString()
            )
        )

        movies.add(
            MovieEntity(
                2,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018",
                69.0,
                "English",
                R.drawable.poster_aquaman.toString()
            )
        )

        return movies
    }


    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                3,
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010",
                81.0,
                "English",
                R.drawable.poster_the_walking_dead.toString()
            )
        )

        tvShows.add(
            TvShowEntity(
                4,
                "The Simpson",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989",
                78.0,
                "English",
                R.drawable.poster_the_simpson.toString()
            )
        )

        return tvShows
    }
}