package raum.muchbeer.daggerhiltcinema.data.api

import raum.muchbeer.daggerhiltcinema.data.model.Movie
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getMoviesResponse(@Query("api_key")apiKey:String) : Response<MovieList>

  /*  @GET("person/popular")
    suspend fun getDopeActs(@Query("api_key") apiKey: String) : Response<ArtistList>  */

    @GET("movie/popular")
    suspend fun getMoviesList(@Query("api_key") apiKey: String) : List<MovieList>

    @GET("movie/popular")
    suspend fun getMoviesTrial(@Query("api_key")apiKey:String) : Call<MovieNetworkEntity>

}