package com.koma.leathersheath.main.presenter;

import android.content.Context;

import com.koma.leathersheath.main.contract.MainContract;
import com.koma.leathersheath.main.view.fragment.MainFragment;

/**
 * Created by koma on 2016/8/19.
 */
public class MainPresenter implements MainContract.Presenter {
    public static final String TAG = MainPresenter.class.getName();
    private MainFragment mFragment;

    public MainPresenter(Context contetx,MainFragment mainFragment){
        mFragment = mainFragment;
    }
    @Override
    public void start() {

    }
}
