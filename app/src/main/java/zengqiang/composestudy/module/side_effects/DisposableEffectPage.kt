package zengqiang.composestudy.module.side_effects

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember

@Composable
fun DisposableEffectPage() {
    backPressHandler(enabled = false) {
        println("返回键按下")

    }


}


@Composable
fun backPressHandler(enabled: Boolean = true, onBackPressed: () -> Unit) {
    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner wes provided"
    }.onBackPressedDispatcher

    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }

        }
    }

    // DisposableEffect 可以感知到Composable onActive ,onDispose 生命周期
    DisposableEffect(backDispatcher) {
        // backDispatcher 发生变化时重新执行
        backDispatcher.addCallback(backCallback)
        onDispose {
            // 移除backCallback，避免内存泄露
            backCallback.remove()
        }
    }

}