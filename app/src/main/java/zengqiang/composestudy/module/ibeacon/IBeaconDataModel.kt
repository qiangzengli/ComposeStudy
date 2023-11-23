package zengqiang.composestudy.module.ibeacon

import android.bluetooth.BluetoothDevice
import android.bluetooth.le.ScanRecord

/**
 * IBeacon 数据模型
 */
data class IBeaconDataModel(
    val rssi: Int,
    val device: BluetoothDevice,
    val scanRecord: ScanRecord?,

)
