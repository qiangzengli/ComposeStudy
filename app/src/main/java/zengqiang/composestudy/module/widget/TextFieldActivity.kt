package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-30 下午6:51
Author:alan
Desc:
 */
class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ShowTextField()
        }
    }

//    @Composable
//    fun ShowTextField() {
//        var text by savedInstanceState { "" }
//        TextField(
//            value = text,
//            onValueChange = {
//                text = it
//            },//文本改变监听
//
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxWidth(),
////            label = { Text(text = "标签") },//顶部的提示语
//            placeholder = { Text(text = "请输入内容") },//hint提示语
//            backgroundColor = Color.Yellow,//背景颜色
//            visualTransformation = PasswordVisualTransformation(),//输入样式
//            leadingIcon = { Icon(Icons.Filled.Lock) },//前面的图标
//            trailingIcon = {
//                Icon(
//                    Icons.Filled.Delete,
//                    modifier = Modifier.clickable(onClick = {
//                        text = ""
//                    })
//                )
//            },//后面的图标
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Phone,
//                imeAction = ImeAction.Done//ime行为
//            )
//        )
//
//    }
}