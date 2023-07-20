package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

/**
Time: 2021-01-30 下午7:33
Author:alan
Desc:
 */
@Composable
fun IconPage() {
    LazyColumn {
        items(100) {
            Item()
        }
    }
}

@Composable
fun Item() {
    Column(modifier = Modifier.padding(10.dp)) {
        Icon(imageVector = Icons.Outlined.Face, contentDescription = null)
        Divider(thickness = 10.dp, color = Color.Transparent)

    }
}