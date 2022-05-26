package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import zengqiang.composestudy.module.animator.AnimatedContentActivity
import zengqiang.composestudy.module.animator.AnimatedVisibilityActivity
import zengqiang.composestudy.widget.TextItem

class AnimationActivity : ComponentActivity() {
    private val data = arrayListOf("AnimatedVisibility", "AnimatedContent")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                items(data.size, itemContent = {
                    TextItem(msg = data[it]) {
                        when (data[it]) {
                            "AnimatedVisibility" -> startActivity(
                                Intent(
                                    this@AnimationActivity,
                                    AnimatedVisibilityActivity::class.java
                                )
                            )
                            "AnimatedContent" -> startActivity(
                                Intent(
                                    this@AnimationActivity,
                                    AnimatedContentActivity::class.java
                                )
                            )
                        }
                    }
                })

            }
        }
    }
}