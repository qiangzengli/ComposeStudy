package zengqiang.composestudy.module.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
        )
        Box(
            modifier = Modifier
                .width(500.dp)
                .height(500.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Red)
        )
        Text(
            text = "Hello",
            color = Color.LightGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }

}