package raum.muchbeer.daggerhiltcinema.data.api

import org.w3c.dom.Entity
import raum.muchbeer.daggerhiltcinema.domain.model.Movie
import raum.muchbeer.daggerhiltcinema.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<MovieNetworkEntity, Movie>{
    override fun mapFromEntityToDomain(entity: MovieNetworkEntity): Movie {
       return   Movie(
           id = entity.id,
           overview = entity.posterPath,
           posterPath = entity.posterPath,
           releaseDate = entity.releaseDate,
           title = entity.title
       )
    }

    override fun mapFromDomainToEntity(domain: Movie): MovieNetworkEntity {
        return  MovieNetworkEntity(
           id = domain.id,
           overview = domain.overview,
           posterPath = domain.posterPath,
           releaseDate = domain.releaseDate,
           title = domain.title
       )
    }

    fun mapFromEntityListToDomainList(entities : List<MovieNetworkEntity>) : List<Movie> {
        //transform <MovieNetworkEntity> to ->R

        return entities.map { mapFromEntityToDomain(it)  }
    }
    //Map from Network to Dommain
}