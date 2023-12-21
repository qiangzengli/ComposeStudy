package zengqiang.composestudy.module.animator

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widgets.VGap

// AnimatedVisibility 中 content作用域中可以使用animateEnterExit 为单个组件指定动画
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateEnterExitPage() {
    var visibility by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            visibility = !visibility
        }) {
            Text(text = "改变状态")
        }
        VGap(space = 20.dp)

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.weight(1f),
        ) {
            Box(
                modifier = Modifier
                    .animateEnterExit(
                        enter = scaleIn(),
                        exit = scaleOut(),
                    )
                    .fillMaxSize()
                    .background(Color.Blue),

                ) {
                Box(
                    modifier = Modifier
                        .animateEnterExit(
                            enter = slideInHorizontally(),
                            exit = slideOutHorizontally()
                        )
                        .fillMaxSize(0.5f)
                        .align(Alignment.Center)
                        .background(color = Color.Yellow)

                ) {

                }
            }

        }
    }


}
