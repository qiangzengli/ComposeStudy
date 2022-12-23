package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.Routes

/**
Time: 2021-01-31 上午2:47
Author:alan
Desc:
 */
@Composable
fun LayoutPage(navController: NavHostController) {
    val data = arrayListOf("ConstraintLayout", "Row");

    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                when (data[it]) {
                    "ConstraintLayout" -> navController.navigate(Routes.constraint_layout.name)
                    "Row" -> navController.navigate(Routes.row.name)
                }
            }
        })

    }

}