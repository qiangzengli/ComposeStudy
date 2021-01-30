package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.extension.toast

/**
Time: 2021-01-30 下午5:54
Author:alan
Desc:
 */
class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowButton()
        }
    }

    @Composable
    fun ShowButton() {
        Button(
            onClick = {
                toast(ButtonActivity::class.java.simpleName)
            },//点击事件
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
                .background(Color.Transparent),//修饰
            border =
//            BorderStroke(2.dp, Color.White),//边框颜色
            BorderStroke(
                10.dp,
                Brush.radialGradient(listOf(Color.White, Color.Black))
            ),//边框颜色 Brush 中的方法对应
            content = { Text(text = "Hell-ppppppppppppppppppppppffffffffffffffpppppp") },//内容
            contentPadding = PaddingValues(100.dp),//当内容过长的时候才会有效，
            enabled = true,//设置按钮是否可用

//                CutCornerShape(30) //切角按钮
//            RoundedCornerShape(50),//RoundedCornerShape修改按钮形状 如果参数是dp就是修改角度大小 如果是int是百分比
//        elevation ,按钮可点击状态下的 elevation
//        disabledElevation 按钮不可用状态下的elevation
        )
    }
}