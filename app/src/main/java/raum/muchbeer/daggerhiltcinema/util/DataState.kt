package raum.muchbeer.daggerhiltcinema.util

import java.lang.Exception

sealed class DataState<out R> {

    data class Success<T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()

}