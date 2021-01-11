package raum.muchbeer.daggerhiltcinema.data.repository.impl

import raum.muchbeer.daggerhiltcinema.data.db.DBMapper
import raum.muchbeer.daggerhiltcinema.data.db.MovieDBEntity
import raum.muchbeer.daggerhiltcinema.data.db.MovieDao
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.DBDataSource


class DBDataSourceImpl(private val movieDao: MovieDao,  private val dbMapper: DBMapper) : DBDataSource {
    override suspend fun retrieveMovieFromDB(): List<Movie> {
       return dbMapper.mapFromEntityListToDomainList(movieDao.retrieveCinema())
    }

    override suspend fun insertMovie(movie: Movie): Long {
       return movieDao.insertMovie( dbMapper.mapFromDomainToEntity(movie))
    }

    override suspend fun insertListMovie(movies: List<Movie>) {

        movies.forEach {
            dbMapper.mapFromDomainToEntity(it)
        }

    }
}