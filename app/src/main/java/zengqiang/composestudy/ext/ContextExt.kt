package zengqiang.composestudy.ext

import android.bluetooth.BluetoothManager
import android.content.Context

val Context.bluetoothManager get() = this.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
val Context.bluetoothAdapter get() = bluetoothManager.adapter