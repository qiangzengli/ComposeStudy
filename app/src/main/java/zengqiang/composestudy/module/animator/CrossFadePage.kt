package zengqiang.composestudy.module.animator

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun CrossFadePage() {

    var currentPage by remember { mutableStateOf("A") }

    // CrossFade 使用
    Crossfade(targetState = currentPage, label = "") {
        Text(
            when (it) {
                "A" -> "Page A"
                "B" -> "Page B"
                else -> "else "
            },
            modifier = Modifier.clickable {
                currentPage = if (currentPage == "A") "B" else "A"
            }
        )
    }


}