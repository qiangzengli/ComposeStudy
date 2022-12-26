package zengqiang.composestudy.module.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widget.HDivider

@Composable
fun BasicTextFieldPage() {
    BiliBiliTextField(modifier = Modifier) {

    }
}

@Composable
fun BiliBiliTextField(
    modifier: Modifier,
    value: String = "",
    height: Dp = 40.dp,
    hint: String = "输入点东西看看吧",
    onValueChange: ((String) -> Unit)
) {

    BasicTextField(
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentWidth()
            ) {
                HDivider(divider = 10.dp)
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.size(20.dp)
                )
                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(text = hint, color = Color.LightGray)
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
            .padding(10.dp)
            .height(height)
            .background(Color.Green)

    )

}