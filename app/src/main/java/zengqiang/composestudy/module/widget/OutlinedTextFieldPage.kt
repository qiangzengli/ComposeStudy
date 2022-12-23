package zengqiang.composestudy.module.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-30 下午6:51
Author:alan
Desc:
 */
@Composable

fun OutlinedTextFieldPage() {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },//文本改变监听

        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        label = { Text(text = "标签") },//顶部的提示语
        placeholder = { Text(text = "请输入内容") },//hint提示语
//            backgroundColor = Color.Yellow,//背景颜色
        visualTransformation = PasswordVisualTransformation(),//输入样式
        leadingIcon = { Icon(Icons.Filled.Lock, null) },//前面的图标
        trailingIcon = {
            Icon(
                Icons.Filled.Delete,
                modifier = Modifier.clickable(onClick = {
                    text = ""
                }),
                contentDescription = null
            )
        },//后面的图标
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done//ime行为
        ),
    )


}