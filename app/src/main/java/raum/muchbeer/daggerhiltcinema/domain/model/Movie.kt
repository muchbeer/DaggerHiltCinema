package raum.muchbeer.daggerhiltcinema.domain.model


data class Movie(

    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String
)
