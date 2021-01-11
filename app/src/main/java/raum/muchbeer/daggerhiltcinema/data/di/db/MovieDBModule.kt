package raum.muchbeer.daggerhiltcinema.data.di.db

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import raum.muchbeer.daggerhiltcinema.data.db.MovieDB
import raum.muchbeer.daggerhiltcinema.data.db.MovieDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MovieDBModule {

@Singleton
@Provides
fun provideMovieDatabase(@ApplicationContext context: Context) : MovieDB {
    return MovieDB.getMovieDatabaseInstance(context)
}

    @Singleton
    @Provides
    fun provideMovieDao(movieDB: MovieDB) : MovieDao {
        return movieDB.MovieDao()
    }
  }