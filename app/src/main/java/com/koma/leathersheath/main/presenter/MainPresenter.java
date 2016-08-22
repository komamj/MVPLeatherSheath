package com.koma.leathersheath.main.presenter;


import com.koma.leathersheath.base.BaseApplication;
import com.koma.leathersheath.main.contract.MainContract;
import com.koma.leathersheath.main.time.DateTimeManager;
import com.koma.leathersheath.main.view.fragment.MainFragment;
import com.koma.leathersheath.util.LogUtils;

/**
 * Created by koma on 2016/8/19.
 */
public class MainPresenter implements MainContract.Presenter, DateTimeManager.IDateTimeCallback {
    public static final String TAG = MainPresenter.class.getName();
    private MainFragment mMainFragment;
    private DateTimeManager mDateTimeManager;

    public MainPresenter(MainFragment mainFragment) {
        mMainFragment = mainFragment;
        mMainFragment.setPresenter(this);
    }


    @Override
    public void start() {
        LogUtils.i(TAG, "onStart");
        mDateTimeManager = DateTimeManager.getInstance(BaseApplication.getContext());
        mDateTimeManager.open();
        mDateTimeManager.setCallback(this);
    }

    @Override
    public void onResume() {
        LogUtils.i(TAG, "onResume");
        updateTime();
        updateDate();
    }

    @Override
    public void updateTime() {
        LogUtils.i(TAG, "updateTime");
        String time = mDateTimeManager.getTime();
        String ampm = mDateTimeManager.getAmPm();
        if (mMainFragment != null) {
            mMainFragment.refreshTime(time, ampm);
        }
    }

    @Override
    public void updateDate() {
        LogUtils.i(TAG, "updateDate");
        String date = mDateTimeManager.getDate();
        String week = mDateTimeManager.getWeek();
        if (mMainFragment != null) {
            mMainFragment.refreshDate(date, week);
        }
    }

    @Override
    public void updateWeather() {
        LogUtils.i(TAG, "updateWeather");
    }

    @Override
    public void updateUnRead() {
        LogUtils.i(TAG, "updateUnRead");
    }

    @Override
    public void updateMissed() {
        LogUtils.i(TAG, "updateMissed");
    }

    @Override
    public void onDestroy() {
        LogUtils.i(TAG, "onDestroy");
        if (mDateTimeManager != null) {
            mDateTimeManager.close();
        }
    }

    @Override
    public void onDateUpdate(int month, int dayofMonth) {
        LogUtils.i(TAG, "onDateUpdate");
        updateDate();
    }

    @Override
    public void onTimeUpdate(String hour, String minute) {
        LogUtils.i(TAG, "onTimeUpdate");
        updateTime();
    }
}
