package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import zengqiang.composestudy.module.layout.ConstraintLayoutActivity
import zengqiang.composestudy.module.layout.RowActivity
import zengqiang.composestudy.widget.TextItem

/**
Time: 2021-01-31 上午2:47
Author:alan
Desc:
 */
class LayoutActivity : ComponentActivity() {
    private val data = arrayListOf("ConstraintLayout", "Row");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                items(data.size, itemContent = {
                    TextItem(msg = data[it]) {
                        when (data[it]) {
                            "ConstraintLayout" -> startActivity(
                                Intent(
                                    this@LayoutActivity,
                                    ConstraintLayoutActivity::class.java
                                )
                            )
                            "Row" -> startActivity(
                                Intent(
                                    this@LayoutActivity,
                                    RowActivity::class.java
                                )
                            )
                        }
                    }
                })

            }
        }
    }

}