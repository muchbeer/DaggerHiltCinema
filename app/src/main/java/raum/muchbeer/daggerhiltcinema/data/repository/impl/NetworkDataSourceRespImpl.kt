package raum.muchbeer.daggerhiltcinema.data.repository.impl

import android.util.Log
import raum.muchbeer.daggerhiltcinema.BuildConfig
import raum.muchbeer.daggerhiltcinema.data.api.MovieList
import raum.muchbeer.daggerhiltcinema.data.api.MovieService
import raum.muchbeer.daggerhiltcinema.data.api.NetworkMapper
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.NetworkDataSourceResp
import raum.muchbeer.daggerhiltcinema.util.DataState
import retrofit2.Response

class NetworkDataSourceRespImpl(private val movieService: MovieService) : NetworkDataSourceResp {
    override suspend fun getMovies(): List<Movie> {

        lateinit var listOfMoview : List<Movie>

        try {
            listOfMoview  =
                    movieService.getMoviesResponse(BuildConfig.API_KEY).body()!!.results
            Log.d("MovieNetwork", "retrieve from network: ${listOfMoview}")
        }catch (e: Exception) {
            Log.d("NetworkLog", "error is ${e.message}")

        }
        return listOfMoview
        }
    }

