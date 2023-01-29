package zengqiang.composestudy.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-30 下午5:02
Author:alan
Desc:
 */
@Composable
fun TextItem(msg: String, click: () -> Unit) {
    Column {
        Text(
            text = msg, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clickable { click() }
                .padding(10.dp)

        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5f.dp), color = Color.LightGray
        )


    }


}