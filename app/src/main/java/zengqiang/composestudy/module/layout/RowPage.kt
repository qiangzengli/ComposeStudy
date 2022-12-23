package zengqiang.composestudy.module.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

val random = Random(255)
fun randomColor(): Int {
    return random.nextInt()
}
fun randomText(): String {
    return random.nextInt().toChar().toString()
}
@Composable
fun RowPage() {
    Content()
}


@Preview
@Composable
private fun Content() {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .requiredHeight(IntrinsicSize.Max)
            .requiredWidth(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .background(Color.Yellow)
            .alpha(0.3F)
    ) {
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()
        GenerateItem()

    }
}

@Composable
private fun GenerateItem() {
    Text(
        text = randomText(),
        style = TextStyle(
            color =
            Color(randomColor())
        )
    )
}
