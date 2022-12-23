package zengqiang.composestudy.module.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
Time: 2021-01-30 下午6:32
Author:alan
Desc:
 */
@Composable
fun OutLineButtonPage() {
    OutlinedButton(
        onClick = {
        },
        border = BorderStroke(2.dp, Color.Yellow),
        content = { Text(text = "faok") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),

        )
}