package raum.muchbeer.daggerhiltcinema.data.repository.datasource

import raum.muchbeer.daggerhiltcinema.data.db.MovieDBEntity
import raum.muchbeer.daggerhiltcinema.data.model.Movie


interface DBDataSource {

    suspend fun retrieveMovieFromDB() : List<Movie>

    suspend fun insertMovie(movie: Movie) : Long

    suspend fun insertListMovie(movies: List<Movie>)
}