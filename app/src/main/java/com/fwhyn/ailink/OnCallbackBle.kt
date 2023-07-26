package com.fwhyn.ailink

import com.pingwang.bluetoothlib.bean.BleValueBean
import com.pingwang.bluetoothlib.config.BleConfig
import com.pingwang.bluetoothlib.listener.OnCallback

/**
 * Bluetooth search, connection and other operating interfaces
 */
interface OnCallbackBle : OnCallback {

    /**
     * Start scanning device
     */
    fun onStartScan() {}

    /**
     * Called back every time a device is scanned
     */
    fun onScanning(data: BleValueBean?) {}

    /**
     * Scan timeout (completed)
     */
    fun onScanTimeOut() {}

    /**
     * scan exception
     *
     * @param time how many ms before you can scan again
     * @param type type [BleConfig.SCAN_FAILED_SCANNING_TOO_FREQUENTLY] too often
     * [BleConfig.SCAN_FAILED_TOO_THREE] Scan failed more than 3 times
     * [BleConfig.SCAN_FAILED_OUT_OF_HARDWARE_RESOURCES] The hardware does not support (may also be a permission problem)
     */
    fun onScanErr(type: Int, time: Long) {}

    /**
     * connecting
     */
    fun onConnecting(mac: String?) {}

    /**
     * Connection disconnected in UI thread
     */
    override fun onDisConnected(mac: String?, code: Int) {}

    /**
     * Successful connection (discover service), in UI thread
     */
    override fun onServicesDiscovered(mac: String?) {}

    /**
     * Bluetooth is turned on, triggering thread
     */
    override fun bleOpen() {}

    /**
     * Bluetooth is not turned on, triggering thread
     */
    override fun bleClose() {}
}