package raum.muchbeer.daggerhiltcinema.data.di.db

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.daggerhiltcinema.data.api.NetworkMapper
import raum.muchbeer.daggerhiltcinema.data.db.DBMapper
import raum.muchbeer.daggerhiltcinema.data.db.MovieDBEntity
import raum.muchbeer.daggerhiltcinema.data.db.MovieDao
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.DBDataSource
import raum.muchbeer.daggerhiltcinema.data.repository.impl.DBDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DBDataSourceModule {

    @Singleton
    @Provides
    fun providesDBDataSourceModule(movieDao: MovieDao, dbMapper: DBMapper) : DBDataSource {
      return  DBDataSourceImpl(movieDao, dbMapper)
    }
}