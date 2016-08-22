package com.koma.leathersheath.main.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koma.leathersheath.R;
import com.koma.leathersheath.main.contract.MusicContract;
import com.koma.leathersheath.util.LogUtils;

/**
 * Created by koma on 2016/8/22.
 */
public class MusicFragment extends Fragment implements MusicContract.View {
    private static final String TAG = MusicFragment.class.getName();
    private MusicContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        LogUtils.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.music_fragment_layout, container, false);
        return view;
    }

    @Override
    public void setPresenter(MusicContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
