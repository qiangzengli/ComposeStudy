package zengqiang.composestudy.module

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.Routes

@Composable
fun CustomPage(navController: NavHostController) {
    val items = listOf(
        Routes.LAYOUT_MODIFIER.name,
        Routes.LAYOUT_COMPOSABLE.name,
        Routes.USE_DEFAULT_INTRINSIC.name,
        Routes.CUSTOM_INTRINSIC.name,
        Routes.SUB_COMPOSE_LAYOUT.name,
        Routes.CANVAS.name,
        Routes.DRAW_WITH_CONTENT.name,
    )
    LazyColumn {
        items(items.size, itemContent = {
            TextItem(msg = items[it]) {
                navController.navigate(items[it])
            }
        })
    }


}