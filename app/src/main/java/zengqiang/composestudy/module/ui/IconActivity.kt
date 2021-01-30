package zengqiang.composestudy.module.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-30 下午7:33
Author:alan
Desc:
 */
class IconActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowIcon()
        }
    }

    @Composable
    private fun ShowIcon() {
        ScrollableColumn(content = {
            Column(modifier = Modifier.padding(10.dp)) {
                Icon(Icons.Outlined.Face)
                Divider(thickness = 10.dp, color = Color.Transparent)
                Icon(Icons.Filled.DateRange)
                Divider(thickness = 10.dp, color = Color.Transparent)
                Icon(Icons.Default.DateRange)
                Divider(thickness = 10.dp, color = Color.Transparent)
                Icon(Icons.Outlined.Face,tint = Color.Unspecified)


            }
        })

    }
}