package zengqiang.composestudy.module.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widget.VGap

@Composable
fun RowPage() {
    Content()
}


@Preview
@Composable
private fun Content() {

    Column(modifier = Modifier.fillMaxSize()) {
        Item(arrangement = Arrangement.Start)
        VGap(space = 10.dp)
        Item(arrangement = Arrangement.Center)
        VGap(space = 10.dp)
        Item(arrangement = Arrangement.End)
        VGap(space = 10.dp)
        Item(arrangement = Arrangement.SpaceAround)
        VGap(space = 10.dp)
        Item(arrangement = Arrangement.SpaceBetween)
        VGap(space = 10.dp)
        Item(arrangement = Arrangement.SpaceEvenly)
    }
}

@Composable
private fun Item(arrangement: Arrangement.Horizontal) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Yellow),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = arrangement,
        ) {

            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(text = "A")
            }
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(text = "B")
            }
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                ),
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(text = "C")
            }


        }
        Text(
            text = when (arrangement) {
                Arrangement.Start -> "Start"
                Arrangement.Center -> "Center"
                Arrangement.End -> "End"
                Arrangement.SpaceAround -> "SpaceAround"
                Arrangement.SpaceBetween -> "SpaceBetween"
                Arrangement.SpaceEvenly -> "SpaceEvenly"
                else -> "Unknown"
            },
            modifier = Modifier.align { _, _, _ -> IntOffset(100, 0) },
            color = Color.Green.copy(alpha = 0.7f),
            fontWeight = FontWeight.Bold
        )
    }


}
