package com.cowain.gateway.page

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun Study() {
    val items = listOf("ConstraintLayout")
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {

        LazyColumn{
            repeat(items.size){
                item {
                    StudyItem(title = items[it])
                }
            }
        }
        ConstraintLayout {
            var currentPage by remember { mutableStateOf("A") }
            val (contentCrossFade, btnCrossFade, contentAnimatedContent, infiniteContent) = createRefs()
            Button(onClick = {
                currentPage = if (currentPage == "A") "B" else "A"
            }, modifier = Modifier.constrainAs(btnCrossFade) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }) {
                Text(text = "Crossfade改变显示页面")
            }
            // Crossfade 使用
            Crossfade(targetState = currentPage, modifier = Modifier.constrainAs(contentCrossFade) {
                start.linkTo(btnCrossFade.start)
                end.linkTo(btnCrossFade.end)
                top.linkTo(btnCrossFade.bottom, margin = 10.dp)
            }) {
                when (it) {
                    "A" -> Text(text = "Page A")
                    "B" -> Text(text = "Page B")
                }
            }






        }


    }

}

@Composable
fun StudyItem(title: String) {
    Text(
        text = title, modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    )
}