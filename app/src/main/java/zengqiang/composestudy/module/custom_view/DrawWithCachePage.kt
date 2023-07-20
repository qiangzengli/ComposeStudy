package zengqiang.composestudy.module.custom_view

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.R

@Composable
fun DrawWithCachePage() {
    DrawConan()
}

@Composable
fun DrawConan() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val transition = rememberInfiniteTransition()
        val alpha by transition.animateFloat(
            initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse,
            )
        )
        val context = LocalContext.current
        Box(modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                val conan1 = ImageBitmap.imageResource(context.resources, id = R.drawable.conan1)
                val conan2 = ImageBitmap.imageResource(context.resources, id = R.drawable.conan2)
                val conan3 = ImageBitmap.imageResource(context.resources, id = R.drawable.conan3)
                val conan4 = ImageBitmap.imageResource(context.resources, id = R.drawable.conan4)
                val conan5 = ImageBitmap.imageResource(context.resources, id = R.drawable.conan5)
                val conan6 = ImageBitmap.imageResource(context.resources, id = R.drawable.conan6)
                val imageList = mutableListOf(conan1, conan2, conan3, conan4, conan5, conan6)

                onDrawBehind {
                    imageList.forEachIndexed { index, it ->
                        drawImage(
                            image = it,
                            dstSize = IntSize(100.dp.roundToPx(), 100.dp.roundToPx()),
                            dstOffset = IntOffset(
                                200.dp.roundToPx(),
                                (120 * index).dp.roundToPx()
                            ),
                            alpha = alpha
                        )
                    }
                }

            })


    }
}
