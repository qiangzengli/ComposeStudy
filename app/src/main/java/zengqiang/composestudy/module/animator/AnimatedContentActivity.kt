package zengqiang.composestudy.module.animator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class AnimatedContentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val num = remember {
                mutableStateOf(0)
            }
            Column {
                Button(onClick = { ++num.value }) {
                    Text(text = "Add")
                }

            }

        }
    }
}