package com.koma.leathersheath.main.presenter;

import com.koma.leathersheath.main.contract.MusicContract;
import com.koma.leathersheath.main.view.fragment.MusicFragment;

/**
 * Created by koma on 2016/8/22.
 */
public class MusicPresenter implements MusicContract.Presenter {
    private static final String TAG = MusicPresenter.class.getName();
    private MusicFragment mMusicFragment;

    public MusicPresenter(MusicFragment musicFragment) {
        mMusicFragment = musicFragment;
        mMusicFragment.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
