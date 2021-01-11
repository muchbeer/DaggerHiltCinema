package raum.muchbeer.daggerhiltcinema.util

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntityToDomain(entity: Entity) : DomainModel
    fun mapFromDomainToEntity(domain: DomainModel) : Entity
}