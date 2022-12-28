package zengqiang.composestudy.module.custom_view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LayoutComposablePage() {
    MyOwnColumn {
        Text(text = "first")
        Text(text = "second")
        Text(text = "third")
        Text(text = "forth")
        Text(text = "fifth")
        Text(text = "sixth")
    }
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        val placeables = measurables.map { measurable -> measurable.measure(constraints) }
        var yPosition = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }

}