package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.ui.ComposeStudyTheme
import zengqiang.composestudy.widgets.HGap

@Preview
@Composable
fun LayoutModifierPage() {
    Row(modifier = Modifier.fillMaxSize()) {
        TextWithPaddingBaseLine()
        HGap(space = 20.dp)
        TextWithNormalPadding()
    }

}

@Composable
fun TextWithPaddingBaseLine() {
    ComposeStudyTheme {
        Text(
            text = "Hello ",
            modifier = Modifier
                .firstBaseLineToTop(30.dp)
                .background(Color.Green)
        )
    }

}

@Preview
@Composable
fun TextWithNormalPadding() {
    ComposeStudyTheme {
        Text(
            "World",
            Modifier
                .padding(top = 30.dp)
                .background(Color.Green)
        )
    }
}


fun Modifier.firstBaseLineToTop(
    dp: Dp
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]
    val placeableY = dp.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        placeable.placeRelative(0, placeableY)
    }
}