package zengqiang.composestudy.module.animator

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * AnimatedContent 与AnimatedVisibility都是为content添加动画，
 * 区别在于AnimatedVisibility 用来添加组件的离场，出场过渡动画，而Animated则是实现不同组件间的切换动画
 */
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