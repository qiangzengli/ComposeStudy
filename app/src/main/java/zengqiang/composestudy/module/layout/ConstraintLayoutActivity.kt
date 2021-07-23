package zengqiang.composestudy.module.layout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayout {
                // Create references for the composables to constrain
                val (button) = createRefs()
                Button(
                    onClick = {
                        Toast.makeText(
                            this@ConstraintLayoutActivity,
                            "点击按钮",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    // Assign reference "button" to the Button composable
                    // and constrain it to the top of the ConstraintLayout
                    modifier = Modifier.constrainAs(button) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                ) {
                    Text("Button")
                }

                // Assign reference "text" to the Text composable
                // and constrain it to the bottom of the Button composable
//                Text("Text", Modifier.constrainAs(text) {
//                    top.linkTo(button.bottom, margin = 16.dp)
//                })
            }


        }

    }
}