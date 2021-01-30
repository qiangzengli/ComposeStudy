package zengqiang.composestudy.module

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.setContent
import zengqiang.composestudy.module.widget.*
import zengqiang.composestudy.widget.TextItem

/**
Time: 2021-01-30 下午4:58
Author:alan
Desc:
 */
class WidgetActivity : ComponentActivity() {
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
                        "Icon",
                        "Image",
                        "IconToggleButton",
                        "Switch_And_CheckBox",
                        "RadioButton",
                        "TopAppBar",
                        "TabRow"
                    )
                ) {
                    TextItem(
                        msg = it
                    ) {
                        when (it) {
                            "Text" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    TextActivity::class.java
                                )
                            )
                            "Button" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    ButtonActivity::class.java
                                )
                            )
                            "OutlinedButton" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    OutLineButtonActivity::class.java
                                )
                            )
                            "TextButton" -> startActivity(
                                Intent(this@WidgetActivity,
                                    TextButtonActivity::class.java)
                            )
                            "TextField" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    TextFieldActivity::class.java
                                )
                            )
                            "OutlinedTextField" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    OutlinedTextFieldActivity::class.java
                                )
                            )
                            "Icon" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    IconActivity::class.java
                                )
                            )
                            "Image" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    ImageActivity::class.java
                                )
                            )
                            "IconToggleButton" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    IconToggleButtonActivity::class.java
                                )
                            )
                            "Switch_And_CheckBox" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    SwitchActivity::class.java
                                )
                            )
                            "RadioButton" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    RadioButtonActivity::class.java
                                )
                            )
                            "TopAppBar" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    TopAppBarActivity::class.java
                                )
                            )
                            "TabRow" -> startActivity(
                                Intent(
                                    this@WidgetActivity,
                                    TabRowActivity::class.java
                                )
                            )
                        }
                    }
                }

            }
        }
    }


}