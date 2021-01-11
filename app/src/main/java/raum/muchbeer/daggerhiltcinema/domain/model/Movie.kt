package raum.muchbeer.daggerhiltcinema.domain.model


data class Movie(

    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String
)
