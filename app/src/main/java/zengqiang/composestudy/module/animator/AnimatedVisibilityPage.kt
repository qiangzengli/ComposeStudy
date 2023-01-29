package zengqiang.composestudy.module.animator

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widgets.VGap

@Composable
fun AnimatedVisibilityPage() {
//    AnimatedVisibility使用
    var isFavorite by remember {
        mutableStateOf(false)
    }
    var editable by remember {
        mutableStateOf(false)
    }

    val density = LocalDensity.current
    Column() {
        Button(
            onClick = { isFavorite = isFavorite.not() }, modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "收藏")
            AnimatedVisibility(
                visible = isFavorite,
                enter = fadeIn() + expandHorizontally(),
                exit = fadeOut() + shrinkHorizontally()
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 10.dp)
                )
            }
        }

        VGap(space = 20.dp)
        Button(onClick = { editable = editable.not() }) {
            Text(text = "${if (editable) "关闭" else "开启"}编辑")
        }
        VGap(space = 10.dp)
        AnimatedVisibility(
            visible = editable,
            enter = slideInVertically {
                // 从顶部40dp的位置展开
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // 从顶部展开
                expandFrom = Alignment.Top
            ) + fadeIn(
                // 初始透明度
                initialAlpha = 0.3f,
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Text(
                text = "hello",
                modifier = Modifier
                    .height(200.dp)
                    .background(Color.Red)
            )

        }

    }

}
