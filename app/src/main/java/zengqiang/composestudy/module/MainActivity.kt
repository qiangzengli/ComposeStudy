package zengqiang.composestudy.module

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import zengqiang.composestudy.widgets.BlackWhiteWidget
import zengqiang.composestudy.widgets.TextItem
import zengqiang.composestudy.widgets.ComposeNavHost
import zengqiang.composestudy.widgets.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BlackWhiteWidget(enabled = false) {
                ComposeNavHost(
                    navController = navController,
                    startDestination = Routes.HOME.name
                )
            }

        }
    }

}

@Composable
fun HomePage(navController: NavHostController) {
    val data = listOf(
        Routes.WIDGETS.name,
        Routes.ANIMATION.name,
        Routes.LAYOUT.name,
        Routes.SIDE_EFFECTS.name,
        Routes.CUSTOM_VIEW.name,
        Routes.FUNCTION_TEST.name
    )
    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                navController.navigate(data[it])
            }

        })

    }


}
