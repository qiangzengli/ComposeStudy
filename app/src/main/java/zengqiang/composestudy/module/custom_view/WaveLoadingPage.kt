package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.imageResource
import zengqiang.composestudy.R
import kotlin.math.min
import kotlin.math.sin


@Composable
fun WaveLoadingPage() {
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.conan1)

    fun buildWavePath(
        width: Float,
        height: Float,
        amplitude: Float,// 波浪y轴振幅
        progress: Float,//加载进度
    ): Path {
        val adjustHeight = min(height * Math.max(0f, 1 - progress), amplitude)
        val adjustWidth = 2 * width
        val dp = 2f
        return Path().apply {
            reset()
            moveTo(0f, height)
            lineTo(0f, height * (1 - progress))
            if (progress > 0f && progress < 1f) {
                if (adjustHeight > 0) {
                    var x = dp
                    while (x < adjustWidth) {
                        lineTo(
                            x,
                            height * (1 - progress) - adjustHeight / 2f * sin(4.0 * Math.PI * x / adjustWidth).toFloat()
                        )
                        x += dp
                    }
                }
            }
            lineTo(adjustWidth, height * (1 - progress))
            lineTo(adjustWidth, height)
            close()
        }
    }
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawImage(imageBitmap, colorFilter = run {
            val cm = ColorMatrix().apply { setToSaturation(0f) }
            ColorFilter.colorMatrix(cm)
        })

        drawPath(
            path = buildWavePath(
                width = size.width, height = size.height, amplitude = size.height, progress = 0.2f
            ), brush = ShaderBrush(ImageShader(imageBitmap)), alpha = 0.5f
        )
    }


}