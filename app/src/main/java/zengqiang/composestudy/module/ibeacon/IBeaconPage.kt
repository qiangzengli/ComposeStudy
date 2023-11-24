package zengqiang.composestudy.module.ibeacon

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothProfile
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.os.Build
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import zengqiang.composestudy.ext.bluetoothAdapter
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.bytes2Hex
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.isBeaconDevice
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.parseMajor
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.parseMinor
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.parseRssi
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.parseUUID
import zengqiang.composestudy.module.ibeacon.IBeaconParseUtil.rssi2Distance
import zengqiang.composestudy.widgets.VGap


@SuppressLint(
    "MissingPermission", "MutableCollectionMutableState",
    "UnusedMaterialScaffoldPaddingParameter"
)
@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterialApi::class)
@Composable
fun IBeaconPage(navController: NavHostController) {
    val context = LocalContext.current
    // 标记权限是否获取
    var hasAllPermission by remember {
        mutableStateOf(false)
    }

    val bluetoothLeScanner by remember {
        mutableStateOf(context.bluetoothAdapter.bluetoothLeScanner)
    }
    val cameraPermissionState: MultiplePermissionsState = rememberMultiplePermissionsState(
        permissions = mutableListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.BLUETOOTH,
        ).apply {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.S) add(Manifest.permission.BLUETOOTH_SCAN)
        }
    )
    val beconDataModelList = remember {
        mutableStateListOf<IBeaconDataModel>()
    }
    var connectStatus by remember {
        mutableIntStateOf(BluetoothProfile.STATE_DISCONNECTED)
    }

    var bluetoothGatt: BluetoothGatt? by remember {
        mutableStateOf(null)
    }


    val refreshing by remember { mutableStateOf(false) }
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = {
        beconDataModelList.clear()
        hasAllPermission = hasAllPermission.not().not()
    })
    val scanCallback = object : ScanCallback() {
        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            super.onScanResult(callbackType, result)
            result?.also {
                if (it.scanRecord != null) {
                    if (isBeaconDevice(it.scanRecord!!)) {

                        if (!(beconDataModelList.map { dataModel -> dataModel.device.address }
                                .contains(result.device?.address))) {
                            beconDataModelList.add(
                                IBeaconDataModel(
                                    it.rssi,
                                    it.device,
                                    it.scanRecord,
                                )
                            )

                        } else {
                            beconDataModelList[beconDataModelList.indexOf(beconDataModelList.find { seed -> seed.device.address == it.device.address })] =
                                IBeaconDataModel(
                                    it.rssi,
                                    it.device,
                                    it.scanRecord,
                                )

                        }
                    }
                }

            }
        }

    }
    val connectCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            super.onConnectionStateChange(gatt, status, newState)
            Log.d("IBeacon", newState.toString())
            connectStatus = newState
            bluetoothGatt = gatt

        }

//        override fun onCharacteristicWrite(
//            gatt: BluetoothGatt?,
//            characteristic: BluetoothGattCharacteristic?,
//            status: Int
//        ) {
//            super.onCharacteristicWrite(gatt, characteristic, status)
//            Log.d("IBeacon", characteristic.toString())
//
//        }

//        override fun onCharacteristicChanged(
//            gatt: BluetoothGatt,
//            characteristic: BluetoothGattCharacteristic,
//            value: ByteArray
//        ) {
//            super.onCharacteristicChanged(gatt, characteristic, value)
//            Log.d("IBeacon", characteristic.toString())
//        }

//        override fun onCharacteristicRead(
//            gatt: BluetoothGatt,
//            characteristic: BluetoothGattCharacteristic,
//            value: ByteArray,
//            status: Int
//        ) {
//            super.onCharacteristicRead(gatt, characteristic, value, status)
//        }
    }


    Scaffold(
        topBar = {
            TopAppBar {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })

                Text(text = "IBeacon 设备", modifier = Modifier.weight(1f))

                Text(text = "连接状态:${connectStatus.connectStatus}")

            }
        }
    ) {
        Box {
            when {
                cameraPermissionState.allPermissionsGranted -> {
                    hasAllPermission = true
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .pullRefresh(refreshState),
                    ) {
                        items(beconDataModelList.size) { index ->
                            val result = beconDataModelList[index]
                            result.scanRecord?.let {
//                                // rssi
//                                val rssi = parseRssi(hexData).toInt(16).toString(10).toInt() - 256
//                                // 计算距离
//                                val distance = rssi2Distance(
//                                    parseRssi(hexData).toInt(16).toString(10).toInt() - 256
//                                )
                                // 转换为16进制数据
                                val hexData = bytes2Hex(it.bytes!!)
                                // 计算距离
                                val distance = rssi2Distance(
                                    result.rssi,
                                    parseRssi(hexData).toInt(16).toString(10).toInt() - 256
                                )
                                // 显示布局
                                Column(modifier = Modifier
                                    .padding(10.dp)
                                    .clickable {
                                        result.device.connectGatt(
                                            context,
                                            false,
                                            connectCallback
                                        )
                                    }) {
                                    Text(text = result.scanRecord.deviceName ?: "未知设备名")
                                    VGap(space = 5.dp)
                                    Text(text = result.device.address ?: "未知mac地址")
                                    VGap(space = 5.dp)
                                    Text(text = "信号强度：${result.rssi}")
                                    VGap(space = 5.dp)
                                    Text("距离：${String.format("%.2f", distance)} m")
                                    VGap(space = 5.dp)
                                    Text("UUID:${parseUUID(data = hexData)}")
                                    VGap(space = 5.dp)
                                    Text("major:${parseMajor(data = hexData)}")
                                    VGap(space = 5.dp)
                                    Text("minor:${parseMinor(data = hexData)}")

                                }
                            }


                        }
                    }
                }

                else -> {
                    Column {
                        val textToShow = if (cameraPermissionState.shouldShowRationale) {
                            "想要使用蓝牙，需要先授权"
                        } else {
                            "请授权蓝牙权限"
                        }
                        Text(textToShow)
                        Button(onClick = { cameraPermissionState.launchMultiplePermissionRequest() }) {
                            Text("授权蓝牙权限")
                        }
                    }
                }
            }

            LaunchedEffect(hasAllPermission) {
                bluetoothLeScanner.startScan(
                    listOf(ScanFilter.Builder().build()),
                    ScanSettings.Builder().build(),
                    scanCallback
                )
            }

            // 刷新指示器
            PullRefreshIndicator(
                refreshing = refreshing,
                state = refreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )

            DisposableEffect(Unit) {
                onDispose {
                    bluetoothLeScanner.stopScan(scanCallback)
                    bluetoothGatt?.close()
                    bluetoothGatt = null
                }
            }
        }
    }

}


val Int.connectStatus: String
    get() = when (this) {
        BluetoothProfile.STATE_DISCONNECTED -> "连接断开"
        BluetoothProfile.STATE_CONNECTED -> "已连接"
        BluetoothProfile.STATE_CONNECTING -> "连接中..."
        BluetoothProfile.STATE_DISCONNECTING -> "断开中..."
        else -> "未知"
    }


