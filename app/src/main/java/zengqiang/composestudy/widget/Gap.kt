package zengqiang.composestudy.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.Dp

@Composable
fun VGap(space: Dp, color: Color = Transparent) {
    Spacer(
        modifier = Modifier
            .height(space)
            .background(color)
    )
}


@Composable
fun HGap(space: Dp, color: Color = Transparent) {
    Spacer(
        modifier = Modifier
            .width(space)
            .background(color)
    )
}

@Composable
fun VDivider(divider: Dp, color: Color = Transparent) {
    Divider(
        modifier = Modifier
            .height(divider)
            .fillMaxWidth()
            .background(color)
    )
}


@Composable
fun HDivider(divider: Dp, color: Color = Transparent) {
    Spacer(
        modifier = Modifier
            .width(divider)
            .fillMaxHeight()
            .background(color)
    )
}
