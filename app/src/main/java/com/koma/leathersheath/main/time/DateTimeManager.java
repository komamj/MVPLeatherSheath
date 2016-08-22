package com.koma.leathersheath.main.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.format.DateFormat;

import com.koma.leathersheath.util.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by koma on 2016/8/22.
 */
public class DateTimeManager {
    private static final String TAG = DateTimeManager.class.getName();

    private static final String FORMAT_HOUR = "HH"; // 24 format
    private static final String FORMAT_MINUTE = "mm";

    private static final String FORMAT_24HOUR = "HH:mm";
    private static final String FORMAT_12HOUR = "hh:mm";
    private static final String FORMAT_DATE = "yyyy/MM/dd";

    public static int SECOND = 1000;
    public static int MINUTE = 60 * SECOND;
    public static int HOUR = 60 * MINUTE;
    public static int DAY = 24 * HOUR;

    private static DateTimeManager sDateTimeManager;

    private Context mContext;
    private IDateTimeCallback mCallback;
    private DateTimeReceiver mDateTimeReceiver;
    private Calendar mCalendar;

    public static DateTimeManager getInstance(Context context) {
        if (sDateTimeManager == null) {
            sDateTimeManager = new DateTimeManager(context);
        }
        return sDateTimeManager;
    }

    private DateTimeManager(Context context) {
        mContext = context;
        mDateTimeReceiver = new DateTimeReceiver();
        mCalendar = Calendar.getInstance();
    }

    public void open() {
        if (mDateTimeReceiver == null) {
            mDateTimeReceiver = new DateTimeReceiver();
        }

        IntentFilter dateTimeFilter = new IntentFilter();
        dateTimeFilter.addAction(Intent.ACTION_TIME_TICK);
        dateTimeFilter.addAction(Intent.ACTION_TIME_CHANGED);
        dateTimeFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        dateTimeFilter.addAction(Intent.ACTION_LOCALE_CHANGED);
        dateTimeFilter.addAction(Intent.ACTION_DATE_CHANGED);
        mContext.registerReceiver(mDateTimeReceiver, dateTimeFilter);
        LogUtils.i(TAG, "[open]register DataTimeReceiver");
    }

    public void close() {
        if (mDateTimeReceiver != null) {
            mContext.unregisterReceiver(mDateTimeReceiver);
            mDateTimeReceiver = null;
            LogUtils.i(TAG, "[close]unregister DataTimeReceiver");
        }
    }

    public void setCallback(IDateTimeCallback callback) {
        mCallback = callback;
    }

    public boolean is24Hour() {
        return DateFormat.is24HourFormat(mContext);
    }

    public String getTime() {
        boolean is24Hour = is24Hour();

        mCalendar.setTimeInMillis(System.currentTimeMillis());

        String time;
        String format = is24Hour ? FORMAT_24HOUR : FORMAT_12HOUR;
        String language = Locale.getDefault().getLanguage();
        if ("ar".equals(language) || "hi".equals(language)) {
            time = new SimpleDateFormat(format,
                    Locale.ENGLISH).format(mCalendar.getTime());
        } else {
            time = new SimpleDateFormat(format,
                    Locale.getDefault()).format(mCalendar.getTime());
        }

        return time;
    }

    public String getAmPm() {
        boolean is24Hour = is24Hour();
        String ampm = null;
        if (!is24Hour) {
            ampm = mCalendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
        }
        return ampm;
    }

    public String getDate() {
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        return new SimpleDateFormat(FORMAT_DATE, Locale.getDefault()).format(mCalendar.getTime());
    }

    public String getWeek() {
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        return new SimpleDateFormat("E", Locale.getDefault()).format(mCalendar.getTime());
    }

    public static String getHour() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(System.currentTimeMillis());
        return new SimpleDateFormat(FORMAT_HOUR, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getMinute() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(System.currentTimeMillis());
        return new SimpleDateFormat(FORMAT_MINUTE, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getDayOfWeek() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(System.currentTimeMillis());
        return new SimpleDateFormat("E", Locale.getDefault()).format(calendar.getTime());
    }

    public static int getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getDayOfMonth() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    private class DateTimeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.i(TAG, "[DateTimeReceiver]action:%s" + intent.getAction());
            if (mCallback != null) {
                if (Intent.ACTION_TIMEZONE_CHANGED.equals(intent.getAction()) ||
                        Intent.ACTION_TIME_CHANGED.equals(intent.getAction()) ||
                        Intent.ACTION_LOCALE_CHANGED.equals(intent.getAction())) {
                    mCallback.onDateUpdate(getMonth(), getDayOfMonth());
                }
                mCallback.onTimeUpdate(getHour(), getMinute());
            }
        }
    }

    public interface IDateTimeCallback {
        void onDateUpdate(int month, int dayofMonth);
        void onTimeUpdate(String hour, String minute);
    }
}
