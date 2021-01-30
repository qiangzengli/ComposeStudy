package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-31 上午1:34
Author:alan
Desc:
 */
class RadioButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ShowRadioButton()
        }
    }

    @Composable
    fun ShowRadioButton() {
        val tags = arrayListOf("Java", "Kotlin", "Swift", "PHP", "JavaScript", "Objective-C")
        val state = remember { mutableStateOf("Null") }
        Row() {
            tags.forEach {
                Row(modifier = Modifier.clickable(onClick = {
                    state.value = it
                })) {
                    RadioButton(selected = it == state.value,onClick = {
                        state.value=it
                    })
                    Text(text = it,modifier = Modifier.align(alignment = Alignment.CenterVertically))
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

        }
    }
}