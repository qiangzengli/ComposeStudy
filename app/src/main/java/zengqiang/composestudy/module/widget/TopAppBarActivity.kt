package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent

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
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)

                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Share,contentDescription = null)

                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.MoreVert,contentDescription = null)
                }
            }
        )

    }
}