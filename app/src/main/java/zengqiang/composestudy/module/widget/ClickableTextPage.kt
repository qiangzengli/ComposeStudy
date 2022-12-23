package zengqiang.composestudy.module.widget

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalTextApi::class)
@Composable
fun ClickableTextPage() {
    // 多样式第二种方式
    val clickText = buildAnnotatedString {
        withStyle(SpanStyle(color = Color.Blue, fontSize = 20.sp)) {
            append("hello")
        }
        withStyle(SpanStyle(color = Color.Red, fontSize = 100.sp)) {
            append(
                "fasldfaskfdsalfskalfksdfffffffffffffffffffffffffffffffffffffffffffffafffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffaaaaaaaaaaaaaaaa"
            )
        }
        withStyle(SpanStyle(color = Color.Green, fontSize = 120.sp)) {
            pushUrlAnnotation(urlAnnotation = UrlAnnotation("https://www.baidu.com"))
            append("cc")
            pop()
        }
        withStyle(SpanStyle(color = Color.Red, fontSize = 100.sp)) {
            append(
                "fasldfaskfdsalfskalfksdfffffffffffffffffffffffffffffffffffffffffffffafffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffaaaaaaaaaaaaaaaa"
            )
        }
    }
    ClickableText(
        text = clickText,
        onClick = { offset ->
            clickText.getUrlAnnotations(
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                println(it.item.url)
            }

        },
        modifier = Modifier.verticalScroll(rememberScrollState())
    )
}