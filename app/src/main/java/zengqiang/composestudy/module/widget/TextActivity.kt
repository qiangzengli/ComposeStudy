package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zengqiang.composestudy.extension.toast

/**
Time: 2021-01-30 下午4:14
Author:alan
Desc:
这两种方式的区别就在于text参数，一个是String类型，一个是AnnotatedString类型。

text: String
普通的字符串；
text: AnnotatedString
带有不同属性的字符串，例如可以在一串字符中设置某些字符的颜色、字体、大小等属性；
modifier: Modifier = Modifier
这是一个很重要的属性Modifier（修饰符），关于修饰符的问题我们在布局中再仔细学习，这里学习控件就先简单的使用它的宽高以及margin和padding属性即可。
color: Color = Color.Unspecified
字体的颜色
fontSize: TextUnit = TextUnit.Inherit
绘制文本时使用的字形大小。请参见TextStyle.fontSize。
fontStyle: FontStyle? = null
绘制字母时使用的字体变体（例如，斜体）。请参见TextStyle.fontStyle。
fontWeight: FontWeight? = null
绘制文本时要使用的字体粗细（例如FontWeight.Bold）。
fontFamily: FontFamily? = null
呈现文本时要使用的字体系列。请参见TextStyle.fontFamily。
letterSpacing: TextUnit = TextUnit.Inherit
每个字母之间添加的空间量。请参见TextStyle.letterSpacing。
textDecoration: TextDecoration? = null
要在文字上绘制的装饰（例如下划线）。请参见TextStyle.textDecoration。
textAlign: TextAlign? = null
文本在段落中的对齐方式。请参见TextStyle.textAlign。
lineHeight: TextUnit = TextUnit.Inherit
以TextUnit为单位的段落的行高，例如SP或EM。请参见TextStyle.lineHeight。
overflow: TextOverflow = TextOverflow.Clip
视觉溢出应的处理方式，例如尾部显示…或者中间显示…。
softWrap: Boolean = true
文本是否应在换行符处中断。如果为false，则文本的宽度会在水平方向上无限延伸，且textAlign属性失效，可能会出现异常情况。
maxLines: Int = Int.MAX_VALUE
文本可跨越的可选最大行数，必要时可以换行。如果文本超过给定的行数，则会根据textAlign和softWrap属性截断文本。它的值必须大于零。
onTextLayout: (TextLayoutResult) -> Unit = {}
计算新的文本布局时执行的回调。
style: TextStyle = AmbientTextStyle.current
文本的样式配置，例如颜色，字体，行高等。也就是说上面属性中的color,fontSize等一些属性也可以在这里进行声明。具体包含的属性可以参考TextStyle类。
 */
class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowText()
        }
    }

    @Composable
    fun ShowText() {
        Text(
            fontStyle = FontStyle.Italic,//设置字体 Normal 是正常，Italic 斜体
            text = AnnotatedString.Builder("I Love Renxiangqin").run {
                pushStyle(
                    SpanStyle(
                        color = Color.Blue,
                        fontSize = 30.sp,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Cursive
                    )
                )
                append("【可以】")
                pop()//取消上面修改的样式对下文本的影响
                append("I Love Renxiangqin")
                append("I Love Renxiangqin")
                append("I Love Renxiangqin")
                append("I Love Renxiangqin")
                append("I Love Renxiangqin")
                append("I Love Renxiangqin")
                toAnnotatedString()
            }, //显示的内容
            color = Color.Yellow,   //text颜色
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.Red)
                .alpha(1f)
                .clickable(onClick = {
                    toast("hello")
                }),
            fontSize = 20.sp,//字体大小
            fontFamily = FontFamily.SansSerif,//修改字体
            fontWeight = FontWeight.Medium,//修改字重（字体粗细）
            letterSpacing = TextUnit.Sp(10),//字符间距

            textAlign = TextAlign.Justify,//Justify 拉伸填充整个容器， Start Left 左对齐  End  Right 右对齐
            maxLines = 10,//最大行数
            textDecoration = TextDecoration.Underline,//LineThrough 中间划线 Underline 下划线
            style = TextStyle.Default,//text样式
            onTextLayout = {

            },//计算完成回调

            overflow = TextOverflow.Ellipsis

        )

    }
}