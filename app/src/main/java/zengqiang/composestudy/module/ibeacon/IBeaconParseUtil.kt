package zengqiang.composestudy.module.ibeacon

import android.bluetooth.le.ScanRecord
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

    fun calculateDistance(rssi: Int, txPower: Int, pathLossExponent: Double = 2.5): Double {
        // 路径损耗指数模型中的距离计算公式
        val ratio = (txPower - rssi) / (10 * pathLossExponent)
        return 10.0.pow(ratio)
    }
}