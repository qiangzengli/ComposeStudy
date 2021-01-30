package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent

/**
Time: 2021-01-30 下午7:33
Author:alan
Desc:
 */
class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowTopAppBar()
        }
    }

    @Composable
    private fun ShowTopAppBar() {
        TopAppBar(
            title = { Text(text = "标题") },
            navigationIcon = {
                IconButton(onClick = { finish() }) {
                    Icon(Icons.Filled.ArrowBack)

                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Share)

                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.MoreVert)
                }
            }
        )

    }
}