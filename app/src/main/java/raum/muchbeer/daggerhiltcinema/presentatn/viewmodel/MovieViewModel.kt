package raum.muchbeer.daggerhiltcinema.presentation.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import raum.muchbeer.daggerhiltcinema.data.model.Movie
import raum.muchbeer.daggerhiltcinema.domain.repository.Repository
import raum.muchbeer.daggerhiltcinema.util.DataState

class MovieViewModel
@ViewModelInject
constructor(
        private val movieUsecase: Repository,
        @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(){

   private val _datastate : MutableLiveData<DataState<List<Movie>>> = MutableLiveData()

    val datastateLiveData : LiveData<DataState<List<Movie>>>
     get() = _datastate

    fun setMainStateEvent( stateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(stateEvent) {
                is MainStateEvent.getMovie -> {
                  movieUsecase.execute().onEach {
                      _datastate.value = it
                  }.launchIn(viewModelScope)
                }
            }
        }
    }


}

sealed class MainStateEvent {

    object getMovie : MainStateEvent()
    object None : MainStateEvent()
}