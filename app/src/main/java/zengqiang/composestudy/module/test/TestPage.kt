package zengqiang.composestudy.module.test

import android.content.Intent
import android.content.IntentFilter
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


/**
 * @author 李增强
 * @date 2023/07/21  13:19
 * @Copyright Shanghai Yejia Digital Technology Co., Ltd.
 *
 */
@Composable
fun TestPage() {
    val context = LocalContext.current
Column {
    Button(onClick = {
        val receiver = TestReceiver()
        val intentFilter = IntentFilter("zengqiang.test")

        context.registerReceiver(receiver, intentFilter)

    }) {
        Text("注册广播")

    }
    Button(onClick = {
        context.sendBroadcast(Intent("zengqiang.test").apply {
//            putExtra("data","{'name':'李增强'}")
        })
    }) {
        Text("发送")

    }
}


}