package raum.muchbeer.daggerhiltcinema.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import raum.muchbeer.daggerhiltcinema.data.model.Movie

@Database(entities = [MovieDBEntity::class], version = 1, exportSchema = false)
abstract class MovieDB : RoomDatabase() {

    abstract fun MovieDao() : MovieDao

    companion object {
        private var INSTANCE : MovieDB? = null

        fun getMovieDatabaseInstance(context: Context) : MovieDB
        {
            var instance = INSTANCE
            if(instance ==null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDB::class.java,
                    "muchbeer_movie")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }    }
}