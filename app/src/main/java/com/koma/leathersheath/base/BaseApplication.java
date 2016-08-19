package com.koma.leathersheath.base;

import android.app.Application;
import android.content.Context;

import com.koma.leathersheath.util.LogUtils;

/**
 * Created by koma on 2016/8/19.
 */
public class BaseApplication extends Application {
    private static final String TAG = BaseApplication.class.getName();
    private static  Context sContext;
    @Override public void onCreate(){
        super.onCreate();
        LogUtils.i(TAG,"onCreate");
    }
    public static Context getContext(){
        synchronized(BaseApplication.class){
            return sContext;
        }
    }
}
