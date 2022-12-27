package zengqiang.composestudy.module.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.rounded.Password
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import zengqiang.composestudy.module.widget.BiliBiliTextField

@Preview
@Composable
fun ConstraintLayoutPage() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        val (text, button) = createRefs()
        Text(text = "登录",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(text) {
                top.linkTo(parent.top, 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                /**
                 * @see Dimension.wrapContent   实际尺寸根据内容自适应尺寸
                 * @see Dimension.matchParent   实际尺寸铺满父组件尺寸
                 * @see Dimension.fillToConstraints 实际尺寸为根据约束信息拉伸后的尺寸
                 * @see Dimension.preferredWrapContent 如果剩余空间大于根据内容自适应的尺寸时，实际尺寸为自适应尺寸。如果剩余空间小于内容自适应尺寸，则实际尺寸为剩余空间尺寸
                 * @see Dimension.ratio("1:2")  根据字符串计算实际尺寸所占比例
                 * @see Dimension.percent(0.5f) 根据浮点数计算实际尺寸所占比例
                 * @see Dimension.value     将尺寸设置为固定值
                 * @see Dimension.preferredValue   如果剩余空间大于固定值时，实际尺寸为固定值。如果剩余空间小于固定值时，实际尺寸则为剩余空间的尺寸。
                 */
                width = Dimension.wrapContent
            })

        val (tvName, tvPasswd, tfName, tfPasswd) = createRefs()
        val endBarrier = createEndBarrier(tvName, tvPasswd)

        Text(text = "用户名:", modifier = Modifier.constrainAs(tvName) {
            top.linkTo(text.bottom, 20.dp)
            start.linkTo(parent.start)
        })
        Text(text = "密码:", modifier = Modifier.constrainAs(tvPasswd) {
            start.linkTo(parent.start)
            top.linkTo(tvName.bottom, 40.dp)
        })
        var userName by remember { mutableStateOf("") }
        var passwd by remember { mutableStateOf("") }
        BiliBiliTextField(
            value = userName,
            modifier = Modifier.constrainAs(tfName) {
                top.linkTo(tvName.top)
                bottom.linkTo(tvName.bottom)
                start.linkTo(endBarrier)
                end.linkTo(parent.end)
                width = Dimension.preferredWrapContent

            },
            hint = "请输入用户名",
            prefixImageVector = Icons.Default.AccountCircle,
            cursorBrush = SolidColor(Color.Green)
        ) {
            userName = it
        }
        BiliBiliTextField(
            value = passwd,
            modifier = Modifier.constrainAs(tfPasswd) {
                top.linkTo(tvPasswd.top)
                bottom.linkTo(tvPasswd.bottom)
                start.linkTo(endBarrier)
                end.linkTo(parent.end)
                width = Dimension.preferredWrapContent
            },
            hint = "请输入密码",
            prefixImageVector = Icons.Rounded.Password,
            visualTransformation = PasswordVisualTransformation(mask = '*'),
            cursorBrush = SolidColor(Color.Green)
        ) {
            passwd = it
        }
        Button(
            onClick = {
                println("用户名:${userName} 密码:${passwd}")
            },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(tvPasswd.bottom, 30.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
        ) {
            Text(
                text = "登录",
            )
        }

    }

}