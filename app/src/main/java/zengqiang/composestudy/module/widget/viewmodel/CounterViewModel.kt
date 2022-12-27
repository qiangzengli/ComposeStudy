package zengqiang.composestudy.module.widget.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _counter = mutableStateOf(0)
    val counter: State<Int> = _counter
    fun increment() {
        _counter.value = _counter.value + 1
    }

    fun decrement() {
        _counter.value = _counter.value - 1
    }
}