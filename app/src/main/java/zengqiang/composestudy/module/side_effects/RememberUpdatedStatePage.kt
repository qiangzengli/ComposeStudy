package zengqiang.composestudy.module.side_effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStatePage() {
    RememberUpdatedStateTestPage {
        println("哈哈")
    }

}

@Composable
private fun RememberUpdatedStateTestPage(onTimeOut: () -> Unit) {
    val currentOnTimeOut by rememberUpdatedState(newValue = onTimeOut)
    // 此LaunchedEffect 生命周期和RememberUpdatedStateTestPage 一致，不会因为重组而中断
    LaunchedEffect(Unit) {
        delay(10000L)
        currentOnTimeOut()
    }


}