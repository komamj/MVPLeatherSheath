package com.koma.leathersheath.main.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koma.leathersheath.R;
import com.koma.leathersheath.main.contract.MainContract;
import com.koma.leathersheath.util.LogUtils;

/**
 * Created by koma on 2016/8/19.
 */
public class MainFragment extends Fragment implements MainContract.View {
    public static final String TAG = MainFragment.class.getName();
    private MainContract.Presenter mPresenter;
    private TextView mTimeView;
    private TextView mTimeAPView;
    private TextView mDateView;
    private TextView mWeekView;
    private TextView mWeatherView;
    private TextView mTempeView;
    private ImageView mMissedImage;
    private ImageView mUnreadImage;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.i(TAG, "onAtatch");
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        LogUtils.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        LogUtils.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mTimeView = (TextView) view.findViewById(R.id.time);
        mTimeAPView = (TextView) view.findViewById(R.id.ampm);
        mDateView = (TextView) view.findViewById(R.id.date);
        mWeekView = (TextView) view.findViewById(R.id.week);
        mWeatherView = (TextView) view.findViewById(R.id.weather);
        mTempeView = (TextView) view.findViewById(R.id.temperature);
        mMissedImage = (ImageView) view.findViewById(R.id.missed_call);
        mUnreadImage = (ImageView) view.findViewById(R.id.unread_message);
    }

    @Override
    public void onViewCreated(View view, Bundle state) {
        super.onViewCreated(view, state);
        LogUtils.i(TAG, "onViewCreated");
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        LogUtils.i(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(TAG, "onResume");
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.i(TAG, "onDestroyView");
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.i(TAG, "onDetach");
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        LogUtils.i(TAG, "setPresenter");
        mPresenter = presenter;
    }

    @Override
    public void refreshTime(String time, String ampm) {
        mTimeView.setText(time);

        if (ampm != null) {
            mTimeAPView.setVisibility(View.VISIBLE);
            mTimeAPView.setText(ampm);
        } else {
            mTimeAPView.setVisibility(View.GONE);
        }
    }

    @Override
    public void refreshDate(String date, String week) {
        mDateView.setText(date);

        mWeekView.setText(week);
    }

    @Override
    public void refreshWeather() {

    }

    @Override
    public void refreshUnRead() {

    }

    @Override
    public void refreshMissed() {

    }
}
