package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.ComposeNavHost
import zengqiang.composestudy.widgets.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeNavHost(
                navController = navController,
                startDestination = Routes.home.name
            )
        }
    }

}

@Composable
fun HomePage(navController: NavHostController) {
    val data = listOf(
        "Ui",
        "Animation",
        "Layout"
    )
    LazyColumn {
        items(data.size, itemContent = {
            TextItem(
                msg = data[it]
            ) {
                when (data[it]) {
                    "Ui" -> navController.navigate(Routes.widgets.name)
                    "Animation" -> navController.navigate(Routes.animation.name)
                    "Layout" -> navController.navigate(Routes.layout.name)
                }
            }

        })

    }


}
