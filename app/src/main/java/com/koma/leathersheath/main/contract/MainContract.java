package com.koma.leathersheath.main.contract;

import com.koma.leathersheath.base.BasePresenter;
import com.koma.leathersheath.base.BaseView;

/**
 * Created by koma on 2016/8/19.
 */
public interface MainContract {
    interface View extends BaseView<Presenter> {
        void refreshTime(String time, String ampm);

        void refreshDate(String date, String week);

        void refreshWeather();

        void refreshUnRead();

        void refreshMissed();

    }

    interface Presenter extends BasePresenter {
        void onResume();

        void updateTime();

        void updateDate();

        void updateWeather();

        void updateUnRead();

        void updateMissed();

        void onDestroy();
    }
}
