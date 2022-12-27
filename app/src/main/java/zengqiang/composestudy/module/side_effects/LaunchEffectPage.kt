package zengqiang.composestudy.module.side_effects

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LaunchEffectPage() {
    // 异步处理的副作用API，当副作用中存在异步任务的时候，可以选择使用LaunchEffect 来处理副作用
    LaunchEffectTestPage()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LaunchEffectTestPage(
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    var hasError by remember {
        mutableStateOf(false)
    }
    var count by remember {
        mutableStateOf(0)
    }
    if (hasError) {
        LaunchedEffect(scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar(
                message = "Error Message $count",
                actionLabel = "Retry Message $count",
            )
            hasError = false
            count++
        }
    }
    Scaffold(scaffoldState = scaffoldState) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "文本", modifier = Modifier.clickable {
                hasError = true
            })
        }

    }

}
