package zengqiang.composestudy.module.sql

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun SqlLitePage(navController: NavHostController) {

    val context = LocalContext.current
    lateinit var sqLiteOpenHelper: SQLiteOpenHelper
    var db: SQLiteDatabase? by remember {
        mutableStateOf(null)
    }
    val columns = remember {
        mutableStateListOf<ContentValues>()
    }
    var inserting by remember {
        mutableStateOf(false)
    }
    var insertingTransaction by remember {
        mutableStateOf(false)
    }
    var querying by remember {
        mutableStateOf(false)
    }
    var deleteing by remember {
        mutableStateOf(false)
    }
    var dbiniting by remember {
        mutableStateOf(false)
    }
    val insertDataCount = 10000
    var queryDataCount by remember {
        mutableStateOf(0)
    }
    // 记录时常
    var durationInsert by remember {
        mutableStateOf(0L)
    }
    var durationInsertTransaction by remember {
        mutableStateOf(0L)
    }
    var durationQuery by remember {
        mutableStateOf(0L)
    }
    var durationDelete by remember {
        mutableStateOf(0L)
    }


    LaunchedEffect(Unit) {
//        launch(Dispatchers.Main) {
        dbiniting = true
        withContext(Dispatchers.IO) {
            sqLiteOpenHelper = MyDbHelper(context)
            db = sqLiteOpenHelper.writableDatabase
            repeat(insertDataCount) {
                columns.add(ContentValues().apply {
                    put("sortName", it.toString())
                })
            }
        }
        dbiniting = false
//        }

    }

    // 开启协程域
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        if (dbiniting)
            CircularProgressIndicator()
        else
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = {
                    scope.launch {
                        inserting = true
                        val startTime = System.currentTimeMillis()
                        withContext(Dispatchers.IO) {
                            columns.forEachIndexed { index, content ->
                                Log.d("test:插入第$index 条数据", content.toString())
                                db?.insert(TABLE_NAME, null, content)
                            }
                        }
                        val endTime = System.currentTimeMillis()
                        durationInsert = (endTime - startTime)
                        inserting = false
                    }
                }) {
                    Text(text = if (inserting) "数据插入中..." else "插入数据${insertDataCount}条,所用时长$durationInsert ms")
                    if (inserting) Spacer(modifier = Modifier.width(10.dp))
                    if (inserting) CircularProgressIndicator(
                        color = Color.White,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Button(onClick = {
                    scope.launch {

                        insertingTransaction = true
                        val startTime = System.currentTimeMillis()
                        withContext(Dispatchers.IO) {
                            db?.beginTransaction()
                            columns.forEachIndexed { index, content ->
                                Log.d("test:插入第$index 条数据", content.toString())
                                db?.insert(TABLE_NAME, null, content)
                            }
                            db?.setTransactionSuccessful()
                            db?.endTransaction()
                        }
                        val endTime = System.currentTimeMillis()
                        durationInsertTransaction = (endTime - startTime)
                        insertingTransaction = false
                    }
                }) {
                    Text(text = if (insertingTransaction) "数据插入中..." else "事务插入数据${insertDataCount}条,所用时长$durationInsertTransaction ms")
                    if (insertingTransaction) Spacer(modifier = Modifier.width(10.dp))
                    if (insertingTransaction) CircularProgressIndicator(
                        color = Color.White,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Button(onClick = {
                    scope.launch {
                        querying = true
                        val startTime = System.currentTimeMillis()
                        val cursor: Cursor?
                        withContext(Dispatchers.IO) {
                            cursor = db?.rawQuery("select * from $TABLE_NAME", null)
                        }
                        Log.d("test", "查询数据${cursor?.count}")
                        queryDataCount = cursor?.count ?: 0
                        cursor?.close()

                        val endTime = System.currentTimeMillis()
                        durationQuery = (endTime - startTime)
                        querying = false
                    }
                }) {
                    Text(text = if (querying) "查询中..." else "查询数据${queryDataCount}条,所用时长$durationQuery ms")
                }
                Button(onClick = {
                    scope.launch {
                        deleteing = true
                        val startTime = System.currentTimeMillis()

                        withContext(Dispatchers.IO) {
                            db?.execSQL("delete  from $TABLE_NAME ")
                        }
                        val endTime = System.currentTimeMillis()
                        durationDelete = (endTime - startTime)
                        deleteing = false
                    }
                }) {
                    Text(text = if (deleteing) "删除中..." else "删除所有数据,所用时长$durationDelete ms")
                }
            }
    }


    DisposableEffect(key1 = null) {
        onDispose {
            try {
                db?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}