package raum.muchbeer.daggerhiltcinema

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.databinding.ActivityMainBinding
import raum.muchbeer.daggerhiltcinema.presentation.viewmodel.MainStateEvent
import raum.muchbeer.daggerhiltcinema.presentation.viewmodel.MovieViewModel
import raum.muchbeer.daggerhiltcinema.presentatn.adapter.MovieAdapter
import raum.muchbeer.daggerhiltcinema.util.DataState


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MovieViewModel by viewModels()

    // private val cinemaViewModel : CinemaViewModel by viewModels()
    private lateinit var adapter : MovieAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

     //   viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
      //  displayMovies()
        viewModel.setMainStateEvent(MainStateEvent.getMovie)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter({selectItem:Movie->selectedItem(selectItem)})
        binding.movieRecyclerView.adapter = adapter
        displayMovies()
    }


    private fun displayMovies() {
        viewModel.datastateLiveData.observe(this, Observer {
            when (it) {
                is DataState.Success<List<Movie>> -> {
                    displayProgressBar(false)
                    adapter.setList(it.data)
                    adapter.notifyDataSetChanged()
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

    private fun displayErrorMsg(errorMsg: String?) {
        if(errorMsg!= null) {

            Snackbar.make(binding.coordinatorLayout, errorMsg, Snackbar.LENGTH_SHORT)
                    .show()

            Log.d("MainActivity", "error is : ${errorMsg}")
        } else {
           // text_sample.text = "Unknown Error"
            Snackbar.make(binding.coordinatorLayout, "Unknown Error", Snackbar.LENGTH_SHORT)
                    .show()
            Log.d("MainActivity", "Unknown Error")
        }
    }

    private fun displayProgressBar(isVisible: Boolean) {
        binding.movieProgressBar.visibility = if(isVisible) View.VISIBLE else    View.GONE
    }

    private fun selectedItem(movie : Movie) {
       Snackbar.make(binding.coordinatorLayout, "selected ${movie.title}", Snackbar.LENGTH_LONG)
    }
}