package zengqiang.composestudy.module

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widgets.Routes
import zengqiang.composestudy.widgets.TextItem

@Composable
fun FunctionTestPage(navController: NavHostController) {
    val items = listOf(
        Routes.ANDROID_TTS.name,
    )
    LazyColumn {
        items(items.size, itemContent = {
            TextItem(msg = items[it]) {
                navController.navigate(items[it])
            }
        })
    }


}