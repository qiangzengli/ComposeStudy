package zengqiang.composestudy.module.widget

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

private data class Menu(val imageVector: ImageVector, val title: String)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldPage(navController: NavHostController) {
    val menus = listOf(
        Menu(Icons.Default.Home, "首页"),
        Menu(Icons.Default.Message, "消息"),
        Menu(Icons.Default.Person, "个人"),
    )
    var selectIndex by remember {
        mutableStateOf(0)
    }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Scaffold 标题") }, navigationIcon = {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
            })
        },
        bottomBar = {
            BottomNavigation() {
                menus.mapIndexed { index, menu ->
                    BottomNavigationItem(
                        selected = (selectIndex == index),
                        onClick = { selectIndex = index },
                        icon = { Icon(imageVector = menu.imageVector, contentDescription = null) },
                        label = { Text(menu.title) },
                        alwaysShowLabel = true,
                        selectedContentColor = Color.Green,
                        unselectedContentColor = Color.Gray
                    )
                }

            }

        },
        drawerContent = {
            Text(text = "Hello，我是Drawer")
        },
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "主页界面")
        }
        // 可以用于拦截返回事件
        BackHandler(
            enabled = scaffoldState.drawerState.isOpen
        ) {
            coroutineScope.launch {
                scaffoldState.drawerState.close()
            }

        }
    }
}