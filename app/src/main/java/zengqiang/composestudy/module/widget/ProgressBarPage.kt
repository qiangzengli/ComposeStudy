package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widgets.VGap

@Composable
fun ProgressBarPage() {
    var progress by remember {
        mutableStateOf(0f)
    }

    Column {
        Button(onClick = {
            if (progress < 1f) {
                progress += 0.1f
            }
        }) {
            Text("添加0.1f进度")
        }
        VGap(space = 10.dp)
        Button(onClick = {
            if (progress > 0f) {
                progress -= 0.1f

            }
        }) {
            Text("减少0.1f进度")
        }
        VGap(space = 10.dp)
        CircularProgressIndicator(progress = progress)
        VGap(space = 10.dp)
        LinearProgressIndicator(progress = progress)
    }
}