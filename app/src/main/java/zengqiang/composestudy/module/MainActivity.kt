package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import zengqiang.composestudy.widget.TextItem

class MainActivity : ComponentActivity() {
    private val data = listOf(
        "Ui",
        "Animation"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                items(data.size,itemContent = {

                    TextItem(
                        msg = data[it]
                    ) {
                        when (data[it]) {
                            "Ui" -> startActivity(
                                Intent(
                                    this@MainActivity,
                                    WidgetActivity::class.java
                                )
                            )
                        }
                    }

                })

            }
        }

    }


}

