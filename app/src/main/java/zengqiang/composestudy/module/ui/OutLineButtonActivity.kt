package zengqiang.composestudy.module.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.extension.toast

/**
Time: 2021-01-30 下午6:32
Author:alan
Desc:
 */
class OutLineButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowOutLineButton()
        }
    }

    @Composable
    private fun ShowOutLineButton() {
        OutlinedButton(
            onClick = {
                toast("I'm a OutlineButton")
            },
            border = BorderStroke(2.dp, Color.Yellow),
            content = { Text(text = "faok") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            )
    }
}