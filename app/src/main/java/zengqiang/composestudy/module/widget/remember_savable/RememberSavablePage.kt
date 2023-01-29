package zengqiang.composestudy.module.widget.remember_savable

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import zengqiang.composestudy.widgets.VGap

/**
 *在 Composable中可以通过remember跨越重组，来保存状态信息，但是无法跨越Activity和进程
 *
 * 使用remember记录的状态在Activity销毁后会丢失，可以使用rememberSavable
 *
 * 自定义的类通过实现Parcelable并使用Parcelize标注即可，如果是第三方类，可以通过自定义Saver
 *
 */
//@Parcelize
//data class City(val name: String, val country: String) : Parcelable

data class City(val name: String, val country: String)

/**
 * 自定义saver,可以不使用@Parcelize注解标注，也不用实现Parcelable
 * 自定义saver是为了给不能实现Parcelable以及@Parcelize注解标注的类进行保存和恢复的方案
 */
object CitySaver : Saver<City, Bundle> {
    override fun restore(value: Bundle): City? {
        return value.getString("name")?.let { name ->
            value.getString("country")?.let { country ->
                City(name, country)
            }
        }
    }

    override fun SaverScope.save(value: City): Bundle {
        return Bundle().apply {
            putString("name", value.name)
            putString("country", value.country)
        }
    }

}

/**
 * 处理自定义Saver，Compose还提供了ListSaver，MapSaver
 */


@Composable
fun RememberSavablePage() {
    /**Parcelable
     * 以下案例通过旋转屏幕可发现第一个状态无法保存，后面的可以正常保存
     */
    val cityMapSaver = run {
        mapSaver(
            save = { mapOf("Name" to it.name, "Country" to it.country) },
            restore = {
                City(it["Name"] as String, it["Country"] as String)
            }
        )
    }

    val cityListSaver = listSaver<City, Any>(
        save = { listOf(it.name, it.country) },
        restore = { City(it[0] as String, it[1] as String) }
    )

    var state1 by remember {
        mutableStateOf(City("", ""))
    }
    var state2 by rememberSaveable(stateSaver = CitySaver) {
        mutableStateOf(City("", ""))
    }
    var state3 by rememberSaveable(stateSaver = cityMapSaver) {
        mutableStateOf(City("", ""))
    }
    var state4 by rememberSaveable(stateSaver = cityListSaver) {
        mutableStateOf(City("", ""))
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = state1.toString())
        VGap(space = 20.dp)
        Text(text = state2.toString())
        VGap(space = 20.dp)
        Text(text = state3.toString())
        VGap(space = 20.dp)
        Text(text = state4.toString())
        Button(onClick = {
            state1 = City("ShangHai", "China")
            state2 = City("NewYork", "USA")
            state3 = City("London", "UK")
            state4 = City("Beijing", "China")
        }) {
            Text(text = "修改数据")

        }
    }


}