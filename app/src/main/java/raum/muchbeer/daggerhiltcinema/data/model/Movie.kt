package raum.muchbeer.daggerhiltcinema.data.model



data class Movie (

    val id: Int,

    val overview: String,

    val posterPath: String,

    val releaseDate: String,

    val title: String

    ) {
        constructor() : this(0,"","","","")
    }