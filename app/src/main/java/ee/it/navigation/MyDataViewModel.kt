package ee.it.navigation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyDataViewModel(private val state: SavedStateHandle) : ViewModel() {
    val data: MyData = requireNotNull(state.get<MyData>("data"))

    init {
        Log.i("MyDataViewModel", "created $this for $data")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MyDataViewModel", "cleared $this")
    }
}
