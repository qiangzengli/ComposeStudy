package zengqiang.composestudy.extension

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
Time: 2021-01-30 下午3:47
Author:alan
Desc:
 */
fun Activity.toast(s: String) {
    Toast.makeText(this, s, Toast.LENGTH_SHORT).show()

}
fun Fragment.toast(s: String) {
    Toast.makeText(context, s, Toast.LENGTH_SHORT).show()

}