package zengqiang.composestudy.module

import android.content.Intent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import zengqiang.composestudy.module.widget.*
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
        "Text",
        "Button",
        "OutlinedButton",
        "TextButton",
        "TextField",
        "OutlinedTextField",
        "Icon",
        "Image",
        "IconToggleButton",
        "Switch_And_CheckBox",
        "RadioButton",
        "TopAppBar",
        "TabRow",
    )

    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                when (data[it]) {
                    "Text" -> navController.navigate(Routes.text.name)
                    "Button" -> navController.navigate(Routes.button.name)
                    "OutlinedButton" -> navController.navigate(Routes.outline_button.name)
                    "TextButton" -> navController.navigate(Routes.text_button.name)
                    "TextField" -> navController.navigate(Routes.text_field.name)
                    "OutlinedTextField" -> navController.navigate(Routes.outlined_text_field.name)
                    "Icon" -> navController.navigate(Routes.icon.name)
                    "Image" -> navController.navigate(Routes.image.name)
                    "IconToggleButton" -> navController.navigate(Routes.icon_toggle_button.name)
                    "Switch_And_CheckBox" -> navController.navigate(Routes.switch.name)
                    "RadioButton" -> navController.navigate(Routes.radio_button.name)
                    "TopAppBar" -> navController.navigate(Routes.top_appbar.name)
                    "TabRow" -> navController.navigate(Routes.tab_row.name)

                }
            }

        })

    }


}