package zengqiang.composestudy.module.widget.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import zengqiang.composestudy.widget.HGap

@Composable
fun ViewModelPage() {
    val viewModel: CounterViewModel = viewModel()
    CounterComponent(
        value = viewModel.counter,
        increment = viewModel::increment,
        decrement = viewModel::decrement
    )

}

@Composable
private fun CounterComponent(
    value: State<Int>,
    increment: () -> Unit,
    decrement: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { decrement() }) {
            Text(text = "-")
        }
        HGap(space = 10.dp)
        Text(text = value.value.toString(), fontSize = 20.sp)
        HGap(space = 10.dp)
        Button(onClick = { increment() }) {
            Text(text = "+")
        }
    }

}