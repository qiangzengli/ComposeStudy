package zengqiang.composestudy.module.animator

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import zengqiang.composestudy.module.layout.ConstraintLayoutPage

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentPage() {
    var animateContent by remember { mutableStateOf("Hello") }
    ConstraintLayout {
        val (contentAnimatedContent) = createRefs()
        AnimatedContent(
            targetState = animateContent,
            modifier = Modifier.constrainAs(contentAnimatedContent) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top, margin = 10.dp)
            }) {
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .clickable {
                        animateContent = if (animateContent == "Hello") "World" else "Hello"
                    }
//                    .animateContentSize()
            ) {
                Text(
                    text = animateContent,
                    style = TextStyle(color = Color.White)
                )

            }
        }

    }

}