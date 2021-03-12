package ee.it.navigation.data

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

internal class MyDataViewModel(private val state: SavedStateHandle) : ViewModel() {
    val data: MyData = requireNotNull(state.get<MyData>(DataNavGraph.args.data))

    init {
        Log.i("MyDataViewModel", "created $this for $data")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MyDataViewModel", "cleared $this")
    }
}
