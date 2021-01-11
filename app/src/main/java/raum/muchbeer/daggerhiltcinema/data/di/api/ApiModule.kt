package raum.muchbeer.daggerhiltcinema.data.di.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.daggerhiltcinema.data.api.MovieRetrofitInstance
import raum.muchbeer.daggerhiltcinema.data.api.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun providesGSONBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson : Gson) : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

 /*   @Singleton
    @Provides
    fun provideMovieService(retrofitBuilder : Retrofit.Builder) : MovieService {
        return retrofitBuilder.build().create(MovieService::class.java)
    }*/

    @Singleton
    @Provides
    fun provideBestMovieService() : MovieService {
        return MovieRetrofitInstance().movieInstance()
    }
}