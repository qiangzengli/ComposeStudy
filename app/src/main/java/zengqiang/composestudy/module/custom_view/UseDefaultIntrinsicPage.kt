package zengqiang.composestudy.module.custom_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 固有特性测量
 */
@Composable
fun UseDefaultIntrinsicPage() {
    TwoTexts(text1 = "first", text2 = "second")
}

@Composable
fun TwoTexts(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String,
) {
    //为高度设置固有特性测量
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start)
                .background(Color.Blue), text = text1
        )
        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(Color.Blue)
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End)
                .background(Color.Blue),
            text = text2
        )


    }
}