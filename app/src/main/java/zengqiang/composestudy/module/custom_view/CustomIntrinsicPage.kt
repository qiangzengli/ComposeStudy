package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

@Composable
fun CustomIntrinsicPage() {
    IntrinsicRow(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {
        Text(
            text = "Left",
            modifier = Modifier
                .wrapContentWidth(Alignment.Start)
                .layoutId("main")
        )
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(4.dp)
                .layoutId("divider")
        )
        Text(
            text = "Right",
            modifier = Modifier
                .wrapContentWidth(Alignment.End)
                .layoutId("main")
        )

    }

}

@Composable
fun IntrinsicRow(
    modifier: Modifier, content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = object : MeasurePolicy {
            override fun MeasureScope.measure(
                measurables: List<Measurable>,
                constraints: Constraints
            ): MeasureResult {
                val dividerConstraints = constraints.copy(minWidth = 0)
                val mainPlaceableList = measurables.filter {
                    it.layoutId == "main"
                }.map {
                    it.measure(constraints)
                }
                val devicePlaceable =
                    measurables.first { it.layoutId == "divider" }.measure(dividerConstraints)
                val midPos = constraints.maxWidth / 2
                return layout(constraints.maxWidth, constraints.maxHeight) {
                    mainPlaceableList.forEach { placeable ->
                        placeable.placeRelative(0, 0)
                    }
                    devicePlaceable.placeRelative(midPos, 0)
                }
            }

            override fun IntrinsicMeasureScope.minIntrinsicHeight(
                measurables: List<IntrinsicMeasurable>, width: Int
            ): Int {
                var maxHeight = 0
                measurables.forEach {
                    maxHeight = it.minIntrinsicHeight(width).coerceAtLeast(maxHeight)
                }
                return maxHeight
            }

//            override fun IntrinsicMeasureScope.maxIntrinsicHeight(
//                measurables: List<IntrinsicMeasurable>,
//                width: Int
//            ): Int {
//                TODO("Not yet implemented")
//            }
//
//            override fun IntrinsicMeasureScope.minIntrinsicWidth(
//                measurables: List<IntrinsicMeasurable>,
//                height: Int
//            ): Int {
//                TODO("Not yet implemented")
//            }
//
//            override fun IntrinsicMeasureScope.maxIntrinsicWidth(
//                measurables: List<IntrinsicMeasurable>,
//                height: Int
//            ): Int {
//                TODO("Not yet implemented")
//            }
        })
}