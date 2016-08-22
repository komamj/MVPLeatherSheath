package com.koma.leathersheath.util;

import android.util.Log;

/**
 * Created by koma on 2016/8/19.
 */
public class LogUtils {
    private static final boolean IS_DEBUG = true;
    private static final String TAG = "LeatherSheath";

    public static void i(String tag, String msg) {
        if (IS_DEBUG) {
            Log.i(TAG, buildString(tag, msg));
        }
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG) {
            Log.e(TAG, buildString(tag, msg));
        }
    }

    private static String buildString(String tag, String msg) {
        StringBuilder sb = new StringBuilder(tag);
        sb.append("----");
        sb.append(msg);
        return sb.toString();
    }
}
