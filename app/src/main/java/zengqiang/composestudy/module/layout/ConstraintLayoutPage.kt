package zengqiang.composestudy.module.layout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
@Composable
fun ConstraintLayoutPage () {



                ConstraintLayout(
        ){
            val (text, button) = createRefs()

            Button(onClick = {},
                modifier = Modifier.constrainAs(button) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                Text(text = "Button")
            }

            Text(text = "Content", modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 20.dp)
                start.linkTo(button.start)
                end.linkTo(button.end)
            })

        }

}