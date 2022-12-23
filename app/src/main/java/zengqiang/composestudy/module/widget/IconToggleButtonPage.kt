package zengqiang.composestudy.module.widget

import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

/**
Time: 2021-01-31 上午1:15
Author:alan
Desc:
 */
@Composable
fun IconToggleButtonPage() {
    val state = remember { mutableStateOf(false) }
    IconToggleButton(
        checked = state.value,
        onCheckedChange = {
            state.value = it
        },
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            tint = if (state.value) Color.Red else Color.Gray,
        )

    }
}