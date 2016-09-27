package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/27.
 */
public class HomepageDetailFragment extends AbsBaseFragment{
    public static HomepageDetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomepageDetailFragment fragment = new HomepageDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage_detail;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
