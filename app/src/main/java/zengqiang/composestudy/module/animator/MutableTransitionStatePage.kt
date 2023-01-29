package zengqiang.composestudy.module.animator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.R
import zengqiang.composestudy.widgets.VGap

/**
 * 动画状态
 */
enum class AnimState {
    VISIBLE,
    INVISIBLE,
    APPEARING,
    DISAPPEARING
}

fun MutableTransitionState<Boolean>.getAnimationState(): AnimState =
    when {
        isIdle && currentState -> AnimState.VISIBLE
        !isIdle && currentState -> AnimState.DISAPPEARING
        isIdle && !currentState -> AnimState.INVISIBLE
        else -> AnimState.APPEARING
    }

/**
 * MutableTransitionState 用于监听动画状态
 */


@Preview
@Composable
fun MutableTransitionStatePage() {
    // 创建MutableTransitionState<Boolean>
    // 以下代码动画会立即执行，可以实现类似开屏动画效果
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = {
            state.targetState = !state.targetState
        }) {
            Text(text = "修改状态")
        }
        Text(text = state.getAnimationState().name)
        VGap(space = 20.dp)
        AnimatedVisibility(
            visibleState = state
        ) {
            Image(
                painter = painterResource(id = R.drawable.b),
                contentDescription = null,
            )
        }


    }


}