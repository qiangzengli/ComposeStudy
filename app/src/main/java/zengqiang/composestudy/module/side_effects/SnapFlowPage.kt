@file:OptIn(ExperimentalPagerApi::class)

package zengqiang.composestudy.module.side_effects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun SnapFlowPage() {
    val pagerState = rememberPagerState()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .collect {
                // currentPage 变化
                println("第 $it 页")
            }
    }

    HorizontalPager(
        count = 10,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Box(contentAlignment = Alignment.Center) {
            Text(text = "第$page 页")
        }


    }
}