package zengqiang.composestudy.module.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widgets.HDivider

@Composable
fun BasicTextFieldPage() {
    var value by remember {
        mutableStateOf("")
    }
    BiliBiliTextField(modifier = Modifier, value = value) {
        value = it

    }
}

@Composable
fun BiliBiliTextField(
    modifier: Modifier,
    value: String = "",
    height: Dp = 30.dp,
    hint: String = "输入点东西看看吧",
    prefixImageVector: ImageVector? = null,
    cursorBrush: Brush = SolidColor(Color.Black),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: ((String) -> Unit)
) {

    BasicTextField(
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        cursorBrush = cursorBrush,
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentWidth()
            ) {
                HDivider(divider = 10.dp)
                if (prefixImageVector != null) Icon(
                    prefixImageVector,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .size(20.dp)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            color = Color.LightGray
                        )
                    }
                    innerTextField()
                }
                if (value.isNotEmpty()) Icon(Icons.Rounded.Clear,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onValueChange("")
                        })
                HDivider(divider = 10.dp)
            }
        },
        modifier = modifier
            .padding(horizontal = 10.dp)
            .height(height)
            .border(1.dp, Color.Green, shape = CircleShape)

    )

}