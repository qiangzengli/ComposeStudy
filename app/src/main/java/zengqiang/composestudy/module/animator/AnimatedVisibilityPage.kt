package zengqiang.composestudy.module.animator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVisibilityPage() {
//    AnimatedVisibility使用
    var data by remember {
        mutableStateOf(false)
    }
    Button(
        onClick = { data = data.not() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text(text = "收藏")
        AnimatedVisibility(visible = data) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 10.dp)
            )
        }
    }
}
