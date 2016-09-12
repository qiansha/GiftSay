package com.lanou3g.giltsay.ui.fragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/9/9.
 */
public class ClassTabSingleFragment extends AbsBaseFragment{
    public static ClassTabSingleFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ClassTabSingleFragment fragment = new ClassTabSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_class_single;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
