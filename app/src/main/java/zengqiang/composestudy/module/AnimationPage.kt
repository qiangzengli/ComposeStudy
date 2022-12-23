package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import zengqiang.composestudy.widget.TextItem
import zengqiang.composestudy.widgets.Routes


@Composable
fun AnimationPage(navController: NavHostController) {
    val data = arrayListOf(
        "AnimatedVisibility",
        "AnimatedContent",
        "CrossFade",
        "RememberInfiniteTransition"
    )

    LazyColumn {
        items(data.size, itemContent = {
            TextItem(msg = data[it]) {
                when (data[it]) {
                    "AnimatedVisibility" -> navController.navigate(Routes.animated_visibility.name)
                    "AnimatedContent" -> navController.navigate(Routes.animated_content.name)
                    "CrossFade" -> navController.navigate(Routes.cross_fade.name)
                    "RememberInfiniteTransition" -> navController.navigate(Routes.remember_infinite_transition.name)
                }
            }
        })

    }
}