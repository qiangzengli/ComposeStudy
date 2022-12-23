package zengqiang.composestudy.module

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.Routes

/**
Time: 2021-01-30 下午4:58
Author:alan
Desc:
 */
@Composable
fun WidgetPage(navController: NavHostController) {
    val data: ArrayList<String> = arrayListOf(
        Routes.TEXT.name,
        Routes.CLICKABLE_TEXT.name,
        Routes.BUTTON.name,
        Routes.OUTLINE_BUTTON.name,
        Routes.TEXT_BUTTON.name,
        Routes.TEXT_FIELD.name,
        Routes.BASIC_TEXT_FIELD.name,
        Routes.OUTLINED_TEXT_FIELD.name,
        Routes.ICON.name,
        Routes.IMAGE.name,
        Routes.ICON_TOGGLE_BUTTON.name,
        Routes.SWITCH.name,
        Routes.RADIO_BUTTON.name,
        Routes.TOP_APPBAR.name,
        Routes.TAB_ROW.name,
        Routes.SELECTION_CONTAINER.name,
    )

    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                navController.navigate(data[it])
            }
        })
    }
}