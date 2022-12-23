package zengqiang.composestudy.module

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.Routes


@Composable
fun AnimationPage(navController: NavHostController) {
    val data = arrayListOf(
        Routes.ANIMATED_VISIBILITY.name,
        Routes.ANIMATED_CONTENT.name,
        Routes.CROSS_FADE.name,
        Routes.REMEMBER_INFINITE_TRANSITION.name,
    )
    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                navController.navigate(data[it])
            }
        })

    }
}