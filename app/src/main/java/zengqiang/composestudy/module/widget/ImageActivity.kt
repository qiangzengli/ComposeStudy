package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.R
import zengqiang.composestudy.ui.purple700


/**
Time: 2021-01-31 上午12:31
Author:alan
Desc:
 */
@ExperimentalFoundationApi
class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ShowImage() }
    }

    //
    @ExperimentalFoundationApi
    @Preview
    @Composable
    fun ShowImage() {
        LazyColumn() {
            items(10, itemContent = {
                Item()
            })
            stickyHeader {
                TopAppBar(
                    title = { Text(text = "标题") },
                    navigationIcon = {
                        IconButton(onClick = { finish() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)

                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Share, contentDescription = null)

                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.MoreVert, contentDescription = null)
                        }
                    }
                )

            }
            items(200, itemContent = {
                Item()
            })


        }
    }


    @Composable
    fun Item() {
        Column() {

            Image(
                painter = painterResource(id = R.drawable.a),
                null,
                alpha = 0.32f,
                alignment = Alignment.BottomEnd,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clickable(onClick = {

                })
            )

            Image(
                painter = painterResource(id = R.drawable.a),
                null,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }


    }
}