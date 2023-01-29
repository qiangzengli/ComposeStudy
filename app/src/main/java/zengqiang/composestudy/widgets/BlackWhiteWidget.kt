package zengqiang.composestudy.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color

@Composable
fun BlackWhiteWidget(enabled: Boolean = false, content: @Composable () -> Unit) {
    Surface {
        content()
        if (enabled) Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(color = Color.White, blendMode = BlendMode.Saturation)
        }

    }
}