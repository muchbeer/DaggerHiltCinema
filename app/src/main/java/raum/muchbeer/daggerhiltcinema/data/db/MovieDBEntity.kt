package raum.muchbeer.daggerhiltcinema.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_tbl")
class MovieDBEntity (

    @PrimaryKey(autoGenerate = false)
val id: Int,

    @ColumnInfo(name = "overview")
val overview: String,

@ColumnInfo(name = "posterPath")
val poster_path: String,

@ColumnInfo(name = "releaseDate")
val release_date: String,

@SerializedName("title")
val title: String

) {
    constructor() : this(0,"","","","")
}