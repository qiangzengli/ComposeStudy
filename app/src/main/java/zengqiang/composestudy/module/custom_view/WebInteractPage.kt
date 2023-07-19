package zengqiang.composestudy.module.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WebInteractPage(navController: NavHostController) {
    var context: Context? by remember {
        mutableStateOf(null)
    }
    context = LocalContext.current
//    var isLoading by remember {
//        mutableStateOf(false)
//    }


    var progress by remember {
        mutableStateOf(0f)
    }


    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }

    var webView: WebView? by remember {
        mutableStateOf(WebView(context!!).apply {

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    progress = newProgress.toFloat() / 100f
                    super.onProgressChanged(view, newProgress)
                }
            }
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                    isLoading = true
                    super.onPageStarted(view, url, favicon)

                }

                override fun onPageFinished(view: WebView?, url: String?) {
//                    isLoading = false
                    super.onPageFinished(view, url)
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
                    .verticalScroll(rememberScrollState())
                    .pullRefresh(state)
            ) {
                AndroidView(factory = { webView!! })
                if (progress != 0f && progress != 1f) LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier.fillMaxWidth()
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