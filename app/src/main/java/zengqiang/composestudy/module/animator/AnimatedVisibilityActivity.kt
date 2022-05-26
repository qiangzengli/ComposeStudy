package zengqiang.composestudy.module.animator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

class AnimatedVisibilityActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val visible = remember {
                mutableStateOf(true)
            }
            Button(onClick = { visible.value = !visible.value }) {
                Row {
                    Text(text = "animated")
                    AnimatedVisibility(
                        visible = visible.value,
                        modifier = Modifier.alpha(1f)
                    ) {
                        Text(text = "visibility")
                    }

                }


            }


        }
    }
}
