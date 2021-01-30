package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

/**
Time: 2021-01-31 上午1:59
Author:alan
Desc:
 */
class TabRowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ShowTabRow()
                ShowScrollableTabRow()
            }
        }
    }

    @Composable
    fun ShowTabRow() {
        val state = remember { mutableStateOf(0) }
        val titles = listOf("生物", "化学", "地理", "物理", "历史")
        Column() {
            TabRow(selectedTabIndex = state.value,
                backgroundColor = Color.Gray,
                contentColor = Color.Yellow,
                tabs = {
                    titles.forEachIndexed { index, title ->
                        Tab(selected = state.value == index,
                            onClick = {
                                state.value = index

                            },
                            text = { Text(text = title) })
                    }

                })
            Spacer(modifier = Modifier.height(20.dp).align(Alignment.CenterHorizontally))
            Text(text = "选中了第 ${state.value + 1} 项")

        }
    }

    @Composable
    fun ShowScrollableTabRow() {
        val state = remember { mutableStateOf(0) }
        val titles = listOf("生物", "化学", "地理", "物理", "历史", "这个是随便添加的充数的")
        Column() {
            ScrollableTabRow(
                selectedTabIndex = state.value,
                backgroundColor = Color.Gray,
                contentColor = Color.Yellow,
                tabs = {
                    titles.forEachIndexed { index, title ->
                        Tab(
//                            icon = { Icon(Icons.Filled.AccountCircle) },
                            content = {

                                Row(
                                    modifier = Modifier
                                        .padding(0.dp, 10.dp)
                                ) {
                                    Text(text = title)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Icon(Icons.Filled.AccountCircle)


                                }

                            },
                            selected = state.value == index,
                            onClick = {
                                state.value = index

                            },
//                            text = { Text(text = title) }
                        )

                    }

                },
                edgePadding = 0.dp,

                )
            Spacer(modifier = Modifier.height(20.dp).align(Alignment.CenterHorizontally))
            Text(text = "选中了第 ${state.value + 1} 项")

        }
    }

}