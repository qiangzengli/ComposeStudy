package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.setContent
import zengqiang.composestudy.module.ui.*
import zengqiang.composestudy.widget.TextItem

/**
Time: 2021-01-30 下午4:58
Author:alan
Desc:
 */
class UiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                items(
                    listOf(
                        "Text",
                        "Button",
                        "OutlinedButton",
                        "TextButton",
                        "TextField",
                        "OutlinedTextField",
                        "Icon"
                    )
                ) {
                    TextItem(
                        msg = it
                    ) {
                        when (it) {
                            "Text" -> startActivity(
                                Intent(
                                    this@UiActivity,
                                    TextActivity::class.java
                                )
                            )
                            "Button" -> startActivity(
                                Intent(
                                    this@UiActivity,
                                    ButtonActivity::class.java
                                )
                            )
                            "OutlinedButton" -> startActivity(
                                Intent(
                                    this@UiActivity,
                                    OutLineButtonActivity::class.java
                                )
                            )
                            "TextButton" -> startActivity(
                                Intent(this@UiActivity, TextButtonActivity::class.java)
                            )
                            "TextField" -> startActivity(
                                Intent(
                                    this@UiActivity,
                                    TextFieldActivity::class.java
                                )
                            )
                            "OutlinedTextField" -> startActivity(
                                Intent(
                                    this@UiActivity,
                                    OutlinedTextFieldActivity::class.java
                                )
                            )      "Icon" -> startActivity(
                                Intent(
                                    this@UiActivity,
                                    IconActivity::class.java
                                )
                            )
                        }
                    }
                }

            }
        }
    }


}