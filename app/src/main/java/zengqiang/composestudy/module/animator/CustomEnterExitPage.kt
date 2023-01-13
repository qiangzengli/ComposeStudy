package zengqiang.composestudy.module.animator

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 想在指定enter和exit后额外指定动画，
 * 使用 transition,添加到transition的动画会在enter/exit动画执行的同时进行
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomEnterExitPage() {
    var visible by remember {
        mutableStateOf(false)
    }
    Column {
        Button(onClick = {
            visible = visible.not()
        }) {
            Text(text = "状态改变")
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            val background by this.transition.animateColor(label = "ColorAnimation") { state ->
                if (state == EnterExitState.Visible) Color.Blue else Color.Yellow
            }
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .background(background)
            )


        }

    }

}