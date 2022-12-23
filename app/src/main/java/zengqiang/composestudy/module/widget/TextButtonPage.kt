package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-30 下午6:42
Author:alan
Desc:
 */
@Composable
fun TextButtonPage() {
    TextButton(
        onClick = {},
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        content = {
            Text(text = "hello")
        }
    )
}