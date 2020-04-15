package com.dragonforest.app.kotlinstudy.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import java.net.NetworkInterface

/**
 * 手机系统信息
 *
 * author: DragonForest
 * time: 2020/3/30
 */
object SystemUtil {

    /**
     * IMEI
     *
     * <p>说明：IMEI 国际移动设备身份码 目前GSM/WCDMA/LTE手机终端需要使用IMEI号码，在单卡工程中一个手机号对应一个IMEI号，双卡手机则会对应两个IMEI号，一张是手机卡对应一个。</p>
     * <p>弊端：如果用户禁用掉相关权限，那么对于以上获取参数的代码。则会直接报错，不会得到我们想要的内容。</p>
     */
    @SuppressLint("MissingPermission")
    fun IMEI(context: Context): String {
        try {
            var telManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                return telManager.getImei(0) ?: ""
            } else {
                return telManager.getDeviceId(0)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    /**
     * IMSI
     *
     * <p>国际移动用户识别码（IMSI：International Mobile Subscriber Identification Number）是区别移动用户的标志，储存在SIM卡中，可用于区别移动用户的有效信息。
     * IMSI总长度不超过15位，同样使用0～9 的数字。其中MCC是移动用户所属国家代号，占3位数字，中国的MCC规定为460；MNC是移动网号码，最多由两位数字组成，用于识别移动用户所归属的移动通信网；
     * MSIN是移动用户识别码，用以识别某一移动通信网中的移动用户。</p>
     */
    @SuppressLint("MissingPermission")
    fun IMSI(context: Context): String {
        var imsi = "NO Search"
        val telephonyManager = context
            .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        imsi = telephonyManager.subscriberId
        return imsi
    }

    /**
     * ANDROID_ID
     * <p>说明：在设备首次运行的时候，系统会随机生成一64位的数字，并把这个数值以16进制保存下来，这个16进制的数字就是ANDROID_ID，但是如果手机恢复出厂设置这个值会发生改变。</p>
     * <p>弊端：1.手机恢复出厂设置以后该值会发生变化 2.在国内Android定制的大环境下，有些设备是不会返回ANDROID_ID的</p>
     */
    fun ANDROID_ID(context: Context): String {
        return Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID)
    }

    /**
     * MAC
     *
     * <p>说明：Mac 指的就是我们设备网卡的唯一设别码，该码全球唯一，一般称为物理地址，硬件地址用来定义设备的位置</p>
     * <p>弊端：1.如果使用Mac地址最重要的一点就是手机必须具有上网功能，2.在Android6.0以后 google 为了运行时权限对geMacAddress();作出修改通过该方法得到的mac地址永远是一样的， 但是可以其他途径获取。</p>
     */
    fun MAC(): String {
        var mac = ""
        var defaultMac = "02:00:00:00:00:02"
        var sf: StringBuffer = StringBuffer()
        try {
            var networkInterface: NetworkInterface? = null
            networkInterface = NetworkInterface.getByName("eth1")
            if (networkInterface == null) {
                networkInterface = NetworkInterface.getByName("wlan0")
            }
            if (networkInterface == null) {
                return defaultMac
            }
            val hardwareAddress = networkInterface.hardwareAddress
            for (b in hardwareAddress) {
                sf.append(String.format("%02X", b))
            }
            if (sf.length > 0) {
                sf.deleteCharAt(sf.length - 1)
            }
            mac = sf.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            mac = defaultMac
        }
        return mac
    }

    /**
     * Serial Number, SN
     */
    fun SN(): String {
        return android.os.Build.SERIAL
    }

    /**
     * Manufacturer 制造商
     */
    fun Manufacturer(): String {
        return android.os.Build.MANUFACTURER
    }

    /**
     * Model 型号
     */
    fun Model(): String {
        return android.os.Build.MODEL
    }

    /**
     * Brand 品牌
     */
    fun Brand(): String {
        return android.os.Build.BRAND
    }

    /**
     * Device 设备名
     */
    fun Device(): String {
        return android.os.Build.DEVICE
    }


    /**
     * 获取设备唯一标识 混合
     */
    fun getUniqueDeviceID(context: Context, refresh: Boolean = false): String {
        if (!refresh) {
            var deviceId = SPStoreUtil.getString(context, "DEVICE_ID_MD5")
            if (!deviceId.equals("")) {
                return deviceId
            }
        }

        var IMEI = IMEI(context)
        var IMSI = IMSI(context)
        var MAC = MAC()
        var ANDROID_ID = ANDROID_ID(context)
        var SN = SN()
        var Manufacturer = Manufacturer()
        var Model = Model()
        var Brand = Brand()
        var Device = Device()

        println("imei->$IMEI")
        println("imsi->$IMSI")
        println("mac->$MAC")
        println("androidID->$ANDROID_ID")
        println("sn->$SN")
        println("Manufacturer->$Manufacturer")
        println("Model->$Model")
        println("Brand->$Brand")
        println("Device->$Device")

        var deviceIDMd5 = SecretUtil.md5(IMEI + IMSI + MAC + ANDROID_ID)
        SPStoreUtil.saveString(context, "DEVICE_ID_MD5", deviceIDMd5)
        return deviceIDMd5
    }


}