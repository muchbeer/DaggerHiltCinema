package raum.muchbeer.daggerhiltcinema.data.repository.datasource

import raum.muchbeer.daggerhiltcinema.data.api.MovieList
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import retrofit2.Response

interface NetworkDataSourceResp {
    suspend fun getMovies() : List<Movie>
}