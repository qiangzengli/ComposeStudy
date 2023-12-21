package zengqiang.composestudy.module.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.*
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

/**
 * @author 李增强
 * @date 2023/07/19  17:35
 * @Copyright Shanghai Yejia Digital Technology Co., Ltd.
 *
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SetJavaScriptEnabled")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WebInteractPage(navController: NavHostController) {
    var context: Context? by remember {
        mutableStateOf(null)
    }
    context = LocalContext.current


    var progress by remember {
        mutableFloatStateOf(0f)
    }


    val refreshing by remember { mutableStateOf(false) }

    val webView: WebView? by remember {
        mutableStateOf(WebView(context!!).apply {
            settings.apply {
                // js 支持
                javaScriptEnabled = true
            }
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    progress = newProgress.toFloat() / 100f
                    super.onProgressChanged(view, newProgress)
                }
            }
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    request?.let { view?.loadUrl(it.url.toString()) }
                    return true
                }

            }
            loadUrl("https://www.baidu.com")
        })
    }

    val state = rememberPullRefreshState(refreshing, onRefresh = {
        webView?.reload()
    })
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(content = {
                Text(text = "网页交互")
            })
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .pullRefresh(state)
                ) {
                    AndroidView(factory = { webView!! })
                }
                if (progress != 0f && progress != 1f) LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier.fillMaxWidth()
                )

                PullRefreshIndicator(
                    refreshing = refreshing,
                    state = state,
                    Modifier.align(Alignment.TopCenter)
                )
            }

        }
    )
    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView?.canGoBack() == true) {
                    webView?.goBack()

                } else {
                    context?.let {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    DisposableEffect(key1 = Unit, effect = {
        dispatcher?.addCallback(callback)
        onDispose {
            callback.remove()
        }
    })

}