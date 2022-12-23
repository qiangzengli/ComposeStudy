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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widget.HDivider

@Composable
fun BasicTextFieldPage() {
    var textFiledBiliBili by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .background(Color(0xFFFB7299))
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = textFiledBiliBili,
            singleLine = true,
            onValueChange = {
                textFiledBiliBili = it
            },
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.matchParentSize()
                ) {
                    HDivider(divider = 10.dp)
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.size(20.dp)
                    )
                    Box(modifier = Modifier.weight(1f)) {
                        if (textFiledBiliBili.isEmpty()) {
                            Text(text = "输入点东西看看吧", color = Color.LightGray)
                        }
                        innerTextField()
                    }
                    if (textFiledBiliBili.isNotEmpty()) Icon(Icons.Rounded.Clear,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                textFiledBiliBili = ""
                            })
                    HDivider(divider = 10.dp)
                }
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(30.dp)
                .background(Color.White, CircleShape)

        )

    }


}