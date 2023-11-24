package zengqiang.composestudy.module.ibeacon

import android.bluetooth.le.ScanRecord
import kotlin.math.abs
import kotlin.math.pow

object IBeaconParseUtil {

    /**
     * 解析UUID
     */
    fun parseUUID(data: String) = data.substring(18, 50)
    fun parseMajor(data: String) = data.substring(50, 54)
    fun parseMinor(data: String) = data.substring(54, 58)
    fun parseRssi(data: String) = data.substring(58, 60)

    /**
     * 字节数组转16进制
     */
    fun bytes2Hex(src: ByteArray): String {
        var result = ""
        src.forEach { byte ->
            result += String.format("%02X", byte)
        }
        return result
    }

    /**
     * 是否是IBeacon设备
     */
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
     * @param rssi 当前设备rssi
     * @param rssiValue 发射端和接收端 相隔1m的信号强度
     */
    fun rssi2Distance(rssi: Int, rssiValue: Int): Double {
        val iRssi = abs(rssi)
        // 发射端和接收端 相隔1m的信号强度
        val s = abs(rssiValue)
        // 环境衰减因子
        val f = 2.0 * 30
        val power = (iRssi - s) / (10 * f)
        return 10.0.pow(power)
    }
}