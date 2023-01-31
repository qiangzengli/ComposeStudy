package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalTextApi::class)
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
    val defaultDegree = -90f
    var hourDegree by remember {
        mutableStateOf(defaultDegree)
    }
    var minuteDegree by remember {
        mutableStateOf(defaultDegree)
    }
    var secondDegree by remember {
        mutableStateOf(defaultDegree)
    }
    val textMeasurer = rememberTextMeasurer()
    val hourFormat = SimpleDateFormat("HH", Locale.CHINA)
    val minuteFormat = SimpleDateFormat("mm", Locale.CHINA)
    val secondFormat = SimpleDateFormat("ss", Locale.CHINA)
    val milliSecondFormat = SimpleDateFormat("SSS", Locale.CHINA)
    // 循环更新时间
    LaunchedEffect(key1 = Unit) {
        repeat(Int.MAX_VALUE) {
            time = System.currentTimeMillis()
            val hour = hourFormat.format(time).toInt()
            val minute = minuteFormat.format(time).toInt()
            val second = secondFormat.format(time).toInt()
            val milliSecond = milliSecondFormat.format(time).toInt()
            secondDegree = defaultDegree + second * (360f / 60)+ milliSecond / 1000f * 6f
            minuteDegree = defaultDegree + minute * (360f / 60) + 6 * secondDegree / 360f
            hourDegree = defaultDegree + hour * (360f / 12) + 30 * (minuteDegree + 90) / 360f
            delay(10L)
        }
    }


    // 手势代码
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        rotation += rotationChange
        offset += offsetChange
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
//         手势代码
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
//                rotationZ = rotation,
//                translationX = offset.x,
//                translationY = offset.y
            )
            .transformable(state = state),
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
            // 绘制渐变
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

            //绘制中央圆点
            drawCircle(Color.Black, radius = 5f.dp.toPx())
            drawCircle(Color.Black.copy(alpha = 0.1f), radius = 5f * 2.dp.toPx())

            // 绘制时针
            rotate(hourDegree) {
                translate(radius.toPx(), radius.toPx()) {
                    drawRoundRect(
                        Color.Black,
                        topLeft = Offset(-hourStrokeHalfWidth.toPx(), -hourStrokeHalfWidth.toPx()),
                        size = Size(hourLength.toPx(), hourStrokeHalfWidth.toPx() * 2),
                        cornerRadius = CornerRadius(10.dp.toPx(), 10.dp.toPx())
                    )
                }
            }
            // 绘制分针
            rotate(minuteDegree) {
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
            rotate(secondDegree) {
                translate(radius.toPx(), radius.toPx()) {
                    drawLine(
                        color = Color.Red,
                        start = Offset(-10.dp.toPx(), 0f),
                        end = Offset(secondLength.toPx(), 0f),
                        strokeWidth = secondStrokeHalfWidth.toPx()
                    )
                }
            }


            // 绘制数字
            for (i in 1..12) {
                val text = buildAnnotatedString {
                    append(i.toString())
                }
                val rect = textMeasurer.measure(text).size
                rotate(defaultDegree + 30f * i) {
                    translate(radius.toPx(), radius.toPx()) {
                        rotate(
                            90 - 30f * i,
                            pivot = Offset(dialRadius - 25.dp.toPx() + rect.center.x, 0f)
                        ) {
                            drawText(
                                textMeasurer,
                                text = i.toString(),
                                topLeft = Offset(dialRadius - 25.dp.toPx(), -rect.height / 2f),
                                style = TextStyle(
                                    fontWeight = if (i % 3 == 0) FontWeight.Bold else FontWeight.Normal,
                                    color = if (i % 3 == 0) Color.Red else Color.Black,
                                    fontSize = if (i % 3 == 0) 16.sp else 12.sp,
                                    fontFamily = FontFamily.Cursive
                                )
                            )

                        }

                    }
                }
            }


        }

    }

}