package zengqiang.composestudy.module.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.loadImageResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.R

/**
Time: 2021-01-31 上午12:31
Author:alan
Desc:
 */
class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ShowImage() }
    }

    @Preview
    @Composable
    fun ShowImage() {
        ScrollableColumn(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()


        ) {

            loadImageResource(id = R.drawable.a).resource.resource?.apply {
                Image(
                    this,
                    alpha = 0.32f,
                    alignment = Alignment.BottomEnd,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clickable(onClick = {

                    })
                )
            }

            loadImageResource(id = R.drawable.a).resource.resource?.apply {
                Image(
                    this,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
            }

            loadImageResource(id = R.drawable.a).resource.resource?.apply {
                Image(

                    this,
                    modifier = Modifier
                        .clip(
                            shape =
//                            RoundedCornerShape(50)
                            CutCornerShape(20)

                        )
                        .border(
                            width = 2.dp, color = Color.Yellow,
                            shape =
//                            RoundedCornerShape(50)
                            CutCornerShape(20)
                        )
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
            }

            loadImageResource(id = R.drawable.a).resource.resource?.apply {
                Image(this)
            }

            loadImageResource(id = R.drawable.a).resource.resource?.apply {
                Image(this)
            }

            loadImageResource(id = R.drawable.a).resource.resource?.apply {
                Image(this)
            }


        }
    }
}