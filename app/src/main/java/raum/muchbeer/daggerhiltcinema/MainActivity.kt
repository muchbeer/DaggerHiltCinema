package raum.muchbeer.daggerhiltcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.presentation.viewmodel.MainStateEvent
import raum.muchbeer.daggerhiltcinema.presentation.viewmodel.MovieViewModel
import raum.muchbeer.daggerhiltcinema.util.DataState
import java.lang.StringBuilder
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MovieViewModel by viewModels()

  //  private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
        displayMovies()
        viewModel.setMainStateEvent(MainStateEvent.getMovie)
    }

    private fun displayMovies() {
        viewModel.datastateLiveData.observe(this, Observer {
            when(it) {
               is DataState.Success<List<Movie>> -> {
                    displayProgressBar(false)
                   appendMovieToText(it.data)
                }

                is DataState.Error -> {
                    displayProgressBar(false)
                    displayErrorMsg(it.exception.message)
                }

                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayErrorMsg( errorMsg : String?) {
        if(errorMsg!= null) {

             text_sample.text = errorMsg
            Log.d("MainActivity", "error is : ${errorMsg}")
        } else {
            text_sample.text = "Unknown Error"
            Log.d("MainActivity", "Unknown Error")
        }
    }

    private fun displayProgressBar(isVisible : Boolean) {
        progressBar.visibility = if(isVisible) View.VISIBLE else    View.GONE
    }

    private fun appendMovieToText(movies: List<Movie>) {
         val sb = StringBuilder()
        movies.forEach {
            sb.append(it.title + "\n")
        }
        text_sample.text = sb.toString()
    }

}