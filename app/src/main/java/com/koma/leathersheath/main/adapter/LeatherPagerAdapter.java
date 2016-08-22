package com.koma.leathersheath.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by koma on 2016/8/22.
 */
public class LeatherPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mListFragment;

    public LeatherPagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        mListFragment = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
