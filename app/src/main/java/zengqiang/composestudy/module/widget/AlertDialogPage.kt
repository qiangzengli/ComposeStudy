package zengqiang.composestudy.module.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun AlertDialogPage() {
    var dialogShown by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { dialogShown = !dialogShown }) {
            Text(text = "显示Dialog")

        }

        if (dialogShown) AlertDialog(
            onDismissRequest = { dialogShown = false },
            confirmButton = {
                TextButton(onClick = { dialogShown = false }) {
                    Text(text = "确定")
                }

            },
            dismissButton = {
                TextButton(onClick = { dialogShown = false }) {
                    Text(text = "取消")
                }
            },
            title = { Text(text = "我是一个AlertDialog") },
            text = {
                Text(
                    text = "我是文本内容"
                )
            })
    }

}