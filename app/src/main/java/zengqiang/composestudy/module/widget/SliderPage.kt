package zengqiang.composestudy.module.widget

import androidx.compose.material.Slider
import androidx.compose.runtime.*

@Composable
fun SliderPage() {
    var value by remember {
        mutableFloatStateOf(0f)
    }
    Slider(
        value = value,
        onValueChange = {
            value = it
        },
        onValueChangeFinished = {
            println(value)
        },
        valueRange = 1f..100f,
        // 进行分段(steps+1段)
        steps = 19
    )
}