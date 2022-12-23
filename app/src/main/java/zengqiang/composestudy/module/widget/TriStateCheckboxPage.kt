package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun TriStateCheckboxPage() {
    val (state1, onStateChange1) = remember { mutableStateOf(true) }
    val (state2, onStateChange2) = remember { mutableStateOf(true) }
    val parentState = remember(state1, state2) {
        if (state1 && state2) ToggleableState.On
        else if (!state1 && !state2) ToggleableState.Off
        else ToggleableState.Indeterminate
    }
    val onParentClick = {
        val s = parentState != ToggleableState.On
        onStateChange1(s)
        onStateChange2(s)
    }

    Column {
        TriStateCheckbox(state = parentState, onClick = onParentClick)
        Checkbox(state1, onStateChange1, modifier = Modifier.padding(start = 10.dp))
        Checkbox(state2, onStateChange2, modifier = Modifier.padding(start = 10.dp))

    }
}