package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.setContent
import zengqiang.composestudy.widget.TextItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                items(
                    listOf(
                        "Ui",
                        "Animation"


                    )
                ) {

                    TextItem(
                        msg = it
                    ) {
                        when (it) {
                            "Ui" -> startActivity(
                                Intent(
                                    this@MainActivity,
                                    WidgetActivity::class.java
                                )
                            )
                        }
                    }

                }

            }
        }

    }


}

