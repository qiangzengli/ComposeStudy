package zengqiang.composestudy.module.widget

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
Time: 2021-01-30 下午7:33
Author:alan
Desc:
 */
@Composable
fun TopAppBarPage(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "标题") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)

            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Share, contentDescription = null)

            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
        }
    )


}