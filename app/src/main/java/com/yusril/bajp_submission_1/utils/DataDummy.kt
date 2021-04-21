package com.yusril.bajp_submission_1.utils

import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.data.MovieEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "movie1",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                2019,
                72,
                "2h 2m",
                "English",
                R.drawable.poster_alita
            )
        )

        movies.add(
            MovieEntity(
                "movie2",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                2018,
                69,
                "2h 23m",
                "English",
                R.drawable.poster_aquaman
            )
        )

        movies.add(
            MovieEntity(
                "movie3",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                2018,
                80,
                "2h 15m",
                "English",
                R.drawable.poster_bohemian
            )
        )

        movies.add(
            MovieEntity(
                "movie4",
                "Cold Persuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                2019,
                57,
                "1h 59m",
                "English",
                R.drawable.poster_cold_persuit
            )
        )

        movies.add(
            MovieEntity(
                "movie5",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                2018,
                69,
                "2h 10m",
                "English",
                R.drawable.poster_creed
            )
        )

        movies.add(
            MovieEntity(
                "movie6",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                2019,
                67,
                "2h 9m",
                "English",
                R.drawable.poster_glass
            )
        )

        movies.add(
            MovieEntity(
                "movie7",
                "How To Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                2019,
                78,
                "1h 44m",
                "English",
                R.drawable.poster_how_to_train
            )
        )

        movies.add(
            MovieEntity(
                "movie8",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                2018,
                83,
                "2h 29m",
                "English",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MovieEntity(
                "movie9",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                2018,
                59,
                "1h 47m",
                "Cantonese",
                R.drawable.poster_master_z
            )
        )

        movies.add(
            MovieEntity(
                "movie10",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                2018,
                61,
                "2h 9m",
                "English",
                R.drawable.poster_mortal_engines
            )
        )

        return movies
    }


    fun generateDummyTvShow(): List<MovieEntity> {

        val tvShows = ArrayList<MovieEntity>()

        tvShows.add(
            MovieEntity(
                "tv1",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                2010,
                81,
                "42m",
                "English",
                R.drawable.poster_the_walking_dead
            )
        )

        tvShows.add(
            MovieEntity(
                "tv2",
                "The Simpson",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                1989,
                78,
                "22m",
                "English",
                R.drawable.poster_the_simpson
            )
        )

        tvShows.add(
            MovieEntity(
                "tv3",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                2005,
                82,
                "45m",
                "English",
                R.drawable.poster_supernatural
            )
        )

        tvShows.add(
            MovieEntity(
                "tv4",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                2015,
                72,
                "42m",
                "English",
                R.drawable.poster_supergirl
            )
        )

        tvShows.add(
            MovieEntity(
                "tv5",
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                2011,
                80,
                "57m",
                "English",
                R.drawable.poster_shameless
            )
        )

        tvShows.add(
            MovieEntity(
                "tv6",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                2017,
                86,
                "45m",
                "English",
                R.drawable.poster_riverdale
            )
        )

        tvShows.add(
            MovieEntity(
                "tv7",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                2013,
                74,
                "45m",
                "English",
                R.drawable.poster_ncis
            )
        )

        tvShows.add(
            MovieEntity(
                "tv8",
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                2017,
                66,
                "55m",
                "English",
                R.drawable.poster_iron_fist
            )
        )

        tvShows.add(
            MovieEntity(
                "tv9",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                2019,
                75,
                "50m",
                "English",
                R.drawable.poster_hanna
            )
        )

        tvShows.add(
            MovieEntity(
                "tv10",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                2005,
                82,
                "43m",
                "English",
                R.drawable.poster_grey_anatomy
            )
        )

        return tvShows
    }
}

