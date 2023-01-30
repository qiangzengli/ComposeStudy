package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ClockPage() {
    val radius = 100.dp
    val shadowWidth = 1.dp

    val hourLength = radius / 3
    val hourStrokeHalfWidth = 3f.dp

    val minuteLength = radius - 30.dp
    val minuteStrokeHalfWidth = 2f.dp

    val secondLength = radius - 20.dp
    val secondStrokeHalfWidth = 1f.dp
    var time by remember {
        mutableStateOf(System.currentTimeMillis())
    }

    LaunchedEffect(key1 = time) {
        time = System.currentTimeMillis()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .size(radius * 2)
        ) {
            // 绘制背景
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFF9F9F9), Color(0xFF666666)),
                    center.copy(y = 0f),
                    center.copy(y = 1f),
                )
            )
            // 绘制渐变，增加
            drawCircle(
                brush = Brush.radialGradient(
                    colorStops = arrayOf(
                        0.9f to Color(0xD8F6F8F9),
                        0.92f to Color(0xD8E5EBEE),
                        0.93f to Color(0xD8CDD4D9),
                        1f to Color(0xD8F5F7F9)
                    ),
                )
            )
            // 绘制阴影
            drawCircle(
                color = Color(0x21000000),
                style = Stroke(width = shadowWidth.toPx()),
                radius = radius.toPx() * 0.92f
            )
            println("translate中心:${this.center}")
            // 绘制刻度
            val dialRadius = radius.toPx() * 0.9f
            val dialColor = Color(0xFF929394)
            for (i in 0..59) {
                rotate(6f * i) {
                    translate(radius.toPx(), radius.toPx()) {
                        drawLine(
                            color = dialColor,
                            start = Offset(
                                dialRadius - (if (i % 5 == 0) 10.dp.toPx() else 4.dp.toPx()),
                                0f
                            ),
                            end = Offset(dialRadius, 0f),
                            strokeWidth = if (i % 5 == 0) 2.dp.toPx() else 1.dp.toPx()
                        )

                    }

                }

            }

            drawCircle(Color.Black, radius = 5f.dp.toPx())
            drawCircle(Color.Black.copy(alpha = 0.1f), radius = 5f * 2.dp.toPx())

            // 绘制时针
            val hourPath = Path().apply {
                this.fillType = PathFillType.NonZero
            }
            hourPath.moveTo(-hourStrokeHalfWidth.toPx(), -hourStrokeHalfWidth.toPx())
            hourPath.lineTo(hourLength.toPx(), -hourStrokeHalfWidth.toPx())
            hourPath.lineTo(hourLength.toPx(), hourStrokeHalfWidth.toPx())
            hourPath.lineTo(-hourStrokeHalfWidth.toPx(), hourStrokeHalfWidth.toPx())
            hourPath.moveTo(hourLength.toPx(), 0f)
            hourPath.addArc(
                Rect(
                    hourLength.toPx(),
                    -10.dp.toPx(),
                    hourLength.toPx() + 20.dp.toPx(),
                    10.dp.toPx()
                ),
                startAngleDegrees = 135f,
                sweepAngleDegrees = 90f,
            )
            hourPath.moveTo(hourLength.toPx() + 2.6.dp.toPx(), -6.8.dp.toPx())
            hourPath.lineTo(hourLength.toPx() + 2.6.dp.toPx(), 6.8.dp.toPx())
            hourPath.lineTo(hourLength.toPx() + 10.dp.toPx() + 10.dp.toPx(), 0f)
            hourPath.close()
            rotate(180f) {

                translate(radius.toPx(), radius.toPx()) {

                    drawPath(hourPath, Color.Black)
                }
            }

            rotate(90f) {
                translate(radius.toPx(), radius.toPx()) {
                    drawRoundRect(
                        Color.Black,
                        Offset(-10.dp.toPx(), -minuteStrokeHalfWidth.toPx()),
                        cornerRadius = CornerRadius(
                            minuteStrokeHalfWidth.toPx(),
                            minuteStrokeHalfWidth.toPx()
                        ),
                        size = Size(minuteLength.toPx(), minuteStrokeHalfWidth.toPx() * 2)
                    )
                }
            }

            drawCircle(Color.Red, radius = 3f.dp.toPx())
            rotate(270f) {
                translate(radius.toPx(), radius.toPx()) {
                    drawLine(
                        color = Color.Red,
                        start = Offset(-10.dp.toPx(), 0f),
                        end = Offset(secondLength.toPx(), 0f),
                        strokeWidth = secondStrokeHalfWidth.toPx() * 2
                    )
                }
            }


        }


    }

}