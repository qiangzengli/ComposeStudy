package zengqiang.composestudy.module.widget

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectionContainerPage() {
    SelectionContainer() {
        Text(text = "可以选中的文字")

    }
}