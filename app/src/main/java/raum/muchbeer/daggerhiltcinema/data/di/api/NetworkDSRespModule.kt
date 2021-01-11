package raum.muchbeer.daggerhiltcinema.data.di.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.daggerhiltcinema.data.api.MovieService
import raum.muchbeer.daggerhiltcinema.data.repository.datasource.NetworkDataSourceResp
import raum.muchbeer.daggerhiltcinema.data.repository.impl.NetworkDataSourceRespImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkDSRespModule {

    @Singleton
    @Provides
    fun providesNetworkDataSourceResp(movieService: MovieService) : NetworkDataSourceResp {
        return NetworkDataSourceRespImpl(movieService)
    }
}