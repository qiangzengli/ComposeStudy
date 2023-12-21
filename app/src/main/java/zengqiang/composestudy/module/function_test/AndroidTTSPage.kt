package zengqiang.composestudy.module.function_test

import android.annotation.SuppressLint
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.EngineInfo
import android.speech.tts.TextToSpeech.QUEUE_FLUSH
import android.speech.tts.TextToSpeech.SUCCESS
import android.speech.tts.Voice
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale

@SuppressLint("MutableCollectionMutableState")
@Composable
fun AndroidTTSPage(navController: NavHostController) {
    val context = LocalContext.current
    var mTts: TextToSpeech? by remember {
        mutableStateOf(null)
    }

    var speechRate by remember {
        mutableStateOf(10f)
    }

    var speechPitch by remember {
        mutableStateOf(10f)
    }

    var speechVoice: Voice? by remember {
        mutableStateOf(null)
    }

    var speechVoiceList: MutableList<Voice> by remember {
        mutableStateOf(mutableListOf())
    }

    var speechEngine: String? by remember {
        mutableStateOf(null)
    }

    var speechEngineList: MutableList<EngineInfo> by remember {
        mutableStateOf(mutableListOf())
    }


    var expand by remember {
        mutableStateOf(false)
    }
    var expandEngine by remember {
        mutableStateOf(false)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            mTts?.speak("三养 奶油拌面杯面 超辣鸡肉味 80g 韩国进口", QUEUE_FLUSH, null, null)
        }) {
            Text(text = "播放")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(text = "语速调整")
            Slider(
                valueRange = 1f..100f,
                value = speechRate,
                onValueChange = {
                    speechRate = it
                },
                onValueChangeFinished = {
                    val result = mTts?.setSpeechRate(speechRate / 10f)
                    if (result == SUCCESS) {
                        Toast.makeText(context, "设置语速成功", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "设置语速失败", Toast.LENGTH_SHORT).show()

                    }
                })

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(text = "音调调整")
            Slider(
                valueRange = 1f..100f,
                value = speechPitch,
                onValueChange = {
                    speechPitch = it
                },
                onValueChangeFinished = {
                    val result = mTts?.setPitch(speechPitch / 10)
                    if (result == SUCCESS) {
                        Toast.makeText(context, "设置语调成功", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(context, "设置语调失败", Toast.LENGTH_SHORT).show()

                    }
                })

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 20.dp)
        ) {

            TextButton(onClick = { expand = true }) {
                Text(text = speechVoice?.name?:"选择Voice")
            }

            DropdownMenu(
                expanded = expand, onDismissRequest = {
                    expand = false
                }, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .background(Color.Yellow)
            ) {
                Text(text = "Voice 列表")
                speechVoiceList.map {
                    DropdownMenuItem(onClick = { mTts?.voice = it }) {
                        Text(text = it.name)
                    }
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 20.dp)
        ) {

            TextButton(onClick = { expandEngine = true }) {
                Text(text = speechEngine ?: "选择引擎")
            }
            DropdownMenu(
                expanded = expandEngine, onDismissRequest = {
                    expandEngine = false
                }, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .background(Color.Yellow)
            ) {
                Text(text = "Speech Engine 列表")

                speechEngineList.map {
                    DropdownMenuItem(onClick = { }) {
                        Text(text = it.name)
                    }
                }
            }

        }
    }





    LaunchedEffect(Unit) {
            mTts = TextToSpeech(context) { status ->
                if (status == SUCCESS) {
                    val result = mTts?.setLanguage(Locale.CHINA)
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "语言不支持", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "当前语言设置为中文，请播放声音", Toast.LENGTH_SHORT)
                            .show()
                    }

                } else {
                    Toast.makeText(context, "初始化失败", Toast.LENGTH_SHORT).show()

                }
            }


            speechEngine = mTts?.defaultEngine ?: ""
            speechEngineList = mTts?.engines ?: mutableListOf()
            Log.d("voice_count engine", speechEngineList.toString())


            speechVoice = mTts?.defaultVoice
            speechVoiceList = mTts?.voices?.toMutableList() ?: mutableListOf()
            Log.d("voice_count voice", speechVoiceList.toString())
        }


    DisposableEffect(true){
        onDispose {
            mTts?.stop()
            mTts?.shutdown()
        }

    }

}