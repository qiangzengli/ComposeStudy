package zengqiang.composestudy.module.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ColumnPage() {
    /**
     * horizontalAlignment 控制水平位置
     * verticalArrangement 控制垂直位置
     */
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text("First Text", modifier = Modifier.align(Alignment.Start))
        Text(text = "Second Text")
        Text(text = "Third Text")
    }
}