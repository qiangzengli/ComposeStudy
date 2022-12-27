package zengqiang.composestudy.module

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.Routes

@Composable
fun SideEffectsPage(navController: NavHostController) {
    val items = listOf(
        Routes.DISPOSABLE_EFFECT.name,
        Routes.SIDE_EFFECT.name,
        Routes.LAUNCH_EFFECT.name,
        Routes.REMEMBER_COROUTINE_SCOPE.name,
        Routes.REMEMBER_UPDATED_STATE.name,
        Routes.SNAP_FLOW.name,
    )
    LazyColumn {
        items(items.size, itemContent = {
            TextItem(msg = items[it]) {
                navController.navigate(items[it])
            }
        })
    }

}