package zengqiang.composestudy.module

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widgets.TextItem
import zengqiang.composestudy.widgets.Routes

/**
Time: 2021-01-31 上午2:47
Author:alan
Desc:
 */
@Composable
fun LayoutPage(navController: NavHostController) {
    val data = arrayListOf(
        Routes.COLUMN.name,
        Routes.CONSTRAINT_LAYOUT.name,
        Routes.CONSTRAINT_LAYOUT_2.name,
        Routes.ROW.name,
        Routes.BOX.name,
    )

    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                navController.navigate(data[it])
            }
        })

    }

}