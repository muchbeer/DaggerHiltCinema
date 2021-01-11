package raum.muchbeer.daggerhiltcinema.presentatn.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import raum.muchbeer.daggerhiltcinema.R
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.databinding.ListItemBinding

class MovieAdapter(private val selectedItem: (Movie)->Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()
    fun setList(movies : List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.list_item, parent,false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Log.d("CinemaAdapter: ", "Movie list Adapter is: ${movieList[position].title}")
        holder.bind(movieList[position], selectedItem)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
    class MovieViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind( movie: Movie, selectedItem: (Movie)->Unit) {
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview
            val posterPath = "https://image.tmdb.org/t/p/w500"+ movie.poster_path
            Log.d("MovieAdapter", "The image Url is : ${posterPath}")
            binding.cardView.setOnClickListener {
                selectedItem(movie)
            }
            Glide.with(binding.imageView.context)
                    .load(posterPath)
                    .error(R.drawable.moviedefault)
                    .into(binding.imageView)

        }
    }

}