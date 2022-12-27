package zengqiang.composestudy.module.side_effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun SideEffectPage() {
    fun doThingSafely() {
        println("do Thing safely")
    }

    fun doThingUnSafely() {
        println("do Thing Unsafely")
    }

    // 每次成功重组的时候都会执行,所以不能用来处理耗时操作或者异步逻辑
    // 跟直接写在Composable中的区别：重组会触发Composable重新执行，但是重组不一定会成功结束，有的重组可能中途失败，SideEffect仅仅在重组成功时候才会执行
    // 能够保证会返回一个正确的状态，或者在正确的时机下进行方法调用
    SideEffect {
        doThingSafely()
    }
    doThingUnSafely()
    throw java.lang.RuntimeException("oops")
}