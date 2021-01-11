package raum.muchbeer.daggerhiltcinema.data.api

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieNetworkEntity (

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("poster_path")
    @Expose
    val poster_path: String,

    @SerializedName("release_date")
    @Expose
    val release_date: String,

    @SerializedName("title")
    @Expose
    val title: String

    )
