package com.lanou3g.giltsay.ui.fragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/9/9.
 */
public class HomePageNormalFragment extends AbsBaseFragment{
    private String tag;
    public static HomePageNormalFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomePageNormalFragment fragment = new HomePageNormalFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage_normal;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
