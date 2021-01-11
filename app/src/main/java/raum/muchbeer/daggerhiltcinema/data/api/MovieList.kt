package raum.muchbeer.daggerhiltcinema.data.api

import com.google.gson.annotations.SerializedName
import raum.muchbeer.daggerhiltcinema.data.model.Movie

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,

    ) {
}