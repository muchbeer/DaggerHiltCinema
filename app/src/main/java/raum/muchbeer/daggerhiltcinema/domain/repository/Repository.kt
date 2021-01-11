package raum.muchbeer.daggerhiltcinema.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.DBDataSource
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.NetworkDataSourceResp
import raum.muchbeer.daggerhiltcinema.util.DataState
import java.lang.Exception

class Repository
constructor(private val dbDataSource: DBDataSource,
                     private val networkDataSource: NetworkDataSourceResp) {

    private val TAG: String = "RepositoryDebug"

    /**
     * Show loading movie from network and then insert to the local db List<Movie>
        */

    suspend fun execute() : Flow<DataState<List<Movie>>> = flow {

        emit(DataState.Loading)
        try {
            val remoteMovies = networkDataSource.getMovies()
            remoteMovies.forEach {
                dbDataSource.insertMovie(it)
            }
            //dbDataSource.insertListMovie(remoteMovies)

            val retrieveMovieDB = dbDataSource.retrieveMovieFromDB()
            emit(DataState.Success(retrieveMovieDB))
        }catch (e: Exception) {
            emit(DataState.Error(e))
        }


    }
}