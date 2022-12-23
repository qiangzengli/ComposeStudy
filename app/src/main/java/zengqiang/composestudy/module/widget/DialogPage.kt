package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun DialogPage() {
    var dialogShown by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { dialogShown = !dialogShown }) {
            Text(text = "显示Dialog")

        }

        if (dialogShown) Dialog(
            onDismissRequest = { dialogShown = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false
            )
        ) {
            Text(text = "你好，我是一个Dialog")

        }
    }

}