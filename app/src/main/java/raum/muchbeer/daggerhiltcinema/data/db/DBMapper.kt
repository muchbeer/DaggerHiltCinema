package raum.muchbeer.daggerhiltcinema.data.db

import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.util.EntityMapper
import javax.inject.Inject

class DBMapper
@Inject
constructor() : EntityMapper<MovieDBEntity, Movie>{
    override fun mapFromEntityToDomain(entity: MovieDBEntity): Movie {
        return Movie(
            id=entity.id,
            overview = entity.overview,
        posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            title = entity.title
        )
    }

    override fun mapFromDomainToEntity(domain: Movie): MovieDBEntity {
        return MovieDBEntity(
            id=domain.id,
            overview = domain.overview,
            posterPath = domain.posterPath,
            releaseDate = domain.releaseDate,
            title = domain.title
        )
    }

    fun mapFromEntityListToDomainList(entities: List<MovieDBEntity>) : List<Movie> {
        return entities.map { mapFromEntityToDomain(it) }
    }

    fun mapFromDomainListToEntityList(entities: List<Movie>) : List<MovieDBEntity> {
        return entities.map { mapFromDomainToEntity(it) }
    }
}