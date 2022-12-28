package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas

@Composable
fun NativeCanvasPage() {
    Canvas(modifier = Modifier.fillMaxSize()) {

        /**
         * 返回的类型为android.graphics.Canvas
         */
        val nativeCanvas = drawContext.canvas.nativeCanvas
        // 原生平台CanvasAPI，支持Android平台所有Canvas API，但是会使得应用失去通用性，有些功能只能在Android平台正常使用
//        nativeCanvas.drawText()

    }

}

