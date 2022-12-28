package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt


@Preview
@Composable
fun CanvasPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var sweepAngle by remember {
            mutableStateOf(0f)
        }
        LoadingProgressBar(value = sweepAngle)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                sweepAngle -= 10f
            }) {
                Text("-")
            }
            Button(onClick = {
                sweepAngle += 10f
            }) {
                Text("+")
            }

        }

    }
}


@Composable
fun LoadingProgressBar(
    value: Float = 0f,
) {
//    assert(value in 0f..100f) { "Value<100且需要>=0" }
//    check(value in 0f..100f) { "Value<100且需要>=0" }
    Box(
        modifier = Modifier.size(375.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Loading",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
            )
            Text(
                text = "${((value / 360f) * 100).roundToInt()}% ",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
            )


        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            drawCircle(
                color = Color(0xFF1E7171),
                center = Offset(drawContext.size.width / 2f, drawContext.size.height / 2f),
                style = Stroke(width = 20.dp.toPx()),
            )
            drawArc(
                color = Color(0xFF3BDCCE),
                startAngle = -90f,
                sweepAngle = value,
                useCenter = false,
//                topLeft = Offset((drawContext.size.width - drawContext.size.height) / 2, 0f),
//                size = Size(drawContext.size.height, drawContext.size.height),
                style = Stroke(width = 20.dp.toPx(), cap = StrokeCap.Round)
            )
        }
    }

}