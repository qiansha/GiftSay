package com.lanou3g.giltsay.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/9/8.
 */
public class HomePageFragment extends AbsBaseFragment{
    private TabLayout homePageTl;
    private ViewPager homePageVp;
    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void initViews() {
        homePageTl = byView(R.id.homepage_tl);
        homePageVp = byView(R.id.homepage_vp);

    }

    @Override
    protected void initDatas() {

    }
}
