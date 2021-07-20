package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.extension.toast

/**
Time: 2021-01-30 下午6:42
Author:alan
Desc:
 */
class TextButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowTextButton()
        }
    }

    @Composable
    private fun ShowTextButton() {
        TextButton(
            onClick = {
                toast("I'm a textButton")
            },
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            content = {
                Text(text = "hello")
            }
        )
    }
}