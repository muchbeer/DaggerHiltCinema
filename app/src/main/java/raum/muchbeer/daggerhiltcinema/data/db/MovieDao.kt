package raum.muchbeer.daggerhiltcinema.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCinemaList(cinemas : List<MovieDBEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDBEntity) : Long

    @Query("DELETE FROM movie_tbl")
    suspend fun deleteAllCinema()

    @Query("SELECT * FROM movie_tbl")
    suspend fun retrieveCinema() : List<MovieDBEntity>
}