package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.R
import zengqiang.composestudy.widgets.VGap

@Composable
fun DrawWithContentPage() {
    Column {
        DrawWithContentDemo()
        VGap(space = 20.dp)
        DrawWithBehindDemo()
    }

}

@Preview
@Composable
private fun DrawWithContentDemo() {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Card(shape = RoundedCornerShape(8.dp), modifier = Modifier
            .size(100.dp)
            .drawWithContent {
                drawContent()
                drawCircle(
                    Color.Red, 18.dp.toPx() / 2, center = Offset(drawContext.size.width, 0f)
                )
            }) {
            Image(
                painter = painterResource(id = R.drawable.conan1), contentDescription = null
            )

        }
    }
}

@Preview
@Composable
private fun DrawWithBehindDemo() {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Card(shape = RoundedCornerShape(8.dp), modifier = Modifier
            .size(100.dp)
            .drawBehind {
                drawCircle(
                    Color.Red, 18.dp.toPx() / 2, center = Offset(drawContext.size.width, 0f)
                )
            }) {
            Image(
                painter = painterResource(id = R.drawable.conan1), contentDescription = null
            )

        }
    }
}