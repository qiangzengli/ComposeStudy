package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-31 上午1:26
Author:alan
Desc:
 */
@Composable
fun SwitchPage() {
    Column {
        ShowSwitch()
        Divider(thickness = 100.dp)
        ShowCheckBox()
    }
}

@Composable
private fun ShowSwitch() {
    val state = remember { mutableStateOf(false) }
    Switch(checked = state.value, onCheckedChange = {
        state.value = it
    })

}

@Composable
private fun ShowCheckBox() {
    val state = remember { mutableStateOf(false) }
    Checkbox(checked = state.value, onCheckedChange = {
        state.value = it
    })

}
