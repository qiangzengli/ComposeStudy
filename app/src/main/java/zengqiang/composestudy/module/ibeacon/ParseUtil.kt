package zengqiang.composestudy.module.ibeacon

import android.bluetooth.le.ScanRecord
import android.util.Log
import kotlin.math.abs
import kotlin.math.pow

object ParseUtil {

    /**
     * 解析UUID
     */
    fun parseUUID(data: String): String {
      return data.substring(18, 50)

    }

    /**
     * 字节数组转16进制
     */

    fun bytes2Hex(src: ByteArray): String {

        var result = ""
        src.forEach { byte ->
            val hv =String.format("%02X", byte)
                result += hv
            Log.d("16进制单次数据",hv)
        }
        Log.d("16进制数据",result)
        Log.d("数据长度",result.length.toString())
        return result
    }
    fun isBeaconDevice(scanRecord: ScanRecord): Boolean {
        val data = scanRecord.bytes
        var startIndex = 2
        var patternFound = false

        while (startIndex <= 5) {
            if (data[startIndex + 2].toInt() and 0xff == 0x02
                && data[startIndex + 3].toInt() and 0xff == 0x15
            ) {
                patternFound = true
                break
            }
            startIndex = startIndex.inc()
        }

        return patternFound

    }

    /**
     * 根据rssi 计算距离
     */
    fun rssi2Distance(rssi: Int): Double {
        val iRssi = abs(rssi)
        // 发射端和接收端 相隔1m的信号强度
        val s = 59
        // 环境衰减因子
        val f = 2.0

        val power = (iRssi - s) / (10 * f)
        return 10.0.pow(power)

    }
}