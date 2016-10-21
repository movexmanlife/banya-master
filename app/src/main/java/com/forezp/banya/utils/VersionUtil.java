package com.forezp.banya.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.forezp.banya.MyApp;

public class VersionUtil {
    public static final String getUserAgent(Context context) {
        return "(Android " + Build.VERSION.RELEASE + ";" + "banya/" + getVersionName(context) + ")";
    }

    /**
     * 获取版本信息
     *
     * @param context
     * @return
     */
    public static final String getVersionName(Context context) {
        String versionName = "";
        try {
            // 获取PackageManager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionName = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    public static final String getVersionCode(Context context) {
        String versionCode = "";
        try {
            // 获取PackageManager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = "" + packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}