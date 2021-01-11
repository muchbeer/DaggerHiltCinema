package raum.muchbeer.daggerhiltcinema.data.di.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.daggerhiltcinema.data.api.MovieService
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.DBDataSource
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.NetworkDataSourceResp
import raum.muchbeer.daggerhiltcinema.data.repository.impl.NetworkDataSourceRespImpl
import raum.muchbeer.daggerhiltcinema.domain.repository.Repository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryDataSourceModule {


    @Singleton
    @Provides
    fun provideMovies(dbDataSource: DBDataSource, networkDataSource: NetworkDataSourceResp
    ): Repository{
        return Repository(dbDataSource, networkDataSource)
    }
}