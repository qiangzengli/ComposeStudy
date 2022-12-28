package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

/**
 * SubComposeLayout 允许子组件的组合阶段延迟到父组件的布局阶段进行，为我们提供了更强的测量定制能力。
 */
@Composable
fun SubComposeLayoutPage() {
    SubComposeRow(modifier = Modifier.fillMaxWidth(), text = {
        Text("Left", Modifier.wrapContentWidth(Alignment.Start))
        Text("Right", Modifier.wrapContentWidth(Alignment.End))
    }) {
        val heightDp = with(LocalDensity.current) { it.toDp() }
        Divider(
            color = Color.Black,
            modifier = Modifier
                .width(4.dp)
                .height(heightDp)
        )


    }

}

@Composable
fun SubComposeRow(
    modifier: Modifier,
    text: @Composable () -> Unit,
    divider: @Composable (Int) -> Unit
) {
    SubcomposeLayout(modifier = modifier) { constraints ->
        var maxHeight = 0
        var placeables = subcompose("text", text).map {
            var placeable = it.measure(constraints)
            maxHeight = placeable.height.coerceAtLeast(maxHeight)
            placeable
        }
        var dividerPlaceable = subcompose("divider") {
            divider(maxHeight)
        }.map {
            it.measure(constraints.copy(minWidth = 0))
        }
//        assert(dividerPlaceable.size==1){"SubcomposeLayout"}
        val midPos = constraints.maxWidth / 2
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                it.placeRelative(0, 0)
            }
            dividerPlaceable.forEach {
                it.placeRelative(midPos, 0)
            }
        }

    }
}