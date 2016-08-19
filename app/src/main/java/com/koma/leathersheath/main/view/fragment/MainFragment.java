package com.koma.leathersheath.main.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koma.leathersheath.main.contract.MainContract;
import com.koma.leathersheath.util.LogUtils;

/**
 * Created by koma on 2016/8/19.
 */
public class MainFragment extends Fragment implements MainContract.View {
    public static final String TAG = MainFragment.class.getName();
    private MainContract.Presenter mPresenter;

    @Override public void onAttach(Context context){
        super.onAttach(context);
        LogUtils.i(TAG,"onAtatch");
    }
    @Override public void onCreate(Bundle state){
        super.onCreate(state);
        LogUtils.i(TAG,"onCreate");
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state){
        LogUtils.i(TAG,"onCreateView");
        return null;
    }
    @Override public void onViewCreated(View view,Bundle state){
        super.onViewCreated(view,state);
        LogUtils.i(TAG,"onViewCreated");
    }
    @Override public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        LogUtils.i(TAG,"onActivityCreated");
    }
    @Override public void onStart(){
        super.onStart();
        LogUtils.i(TAG,"onStart");
    }
    @Override public void onPause(){
        super.onPause();
        LogUtils.i(TAG,"onPause");
    }
    @Override public void onStop(){
        super.onStop();
        LogUtils.i(TAG,"onStop");
    }
    @Override public void onDestroyView(){
        super.onDestroyView();
        LogUtils.i(TAG,"onDestroyView");
    }
    @Override public void onDestroy(){
        super.onDestroy();
        LogUtils.i(TAG,"onDestroy");
    }
    @Override public void onDetach(){
        super.onDetach();
        LogUtils.i(TAG,"onDetach");
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        LogUtils.i(TAG,"setPresenter");
        mPresenter = presenter;
    }
}
