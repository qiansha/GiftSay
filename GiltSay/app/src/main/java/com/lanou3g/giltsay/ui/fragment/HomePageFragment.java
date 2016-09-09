package com.lanou3g.giltsay.ui.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;


import android.support.v4.view.ViewPager;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.adapter.PagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class HomePageFragment extends AbsBaseFragment{
    public static final int myColor       = 0xFFFF0033;

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
        List<Fragment>datas = new ArrayList<>();
        datas.add(new HomePageSelectedFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        datas.add(new HomePageNormalFragment());
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(),datas);
        homePageVp.setAdapter(pagerAdapter);
        homePageTl.setupWithViewPager(homePageVp);
        homePageTl.setSelectedTabIndicatorHeight(3);
        homePageTl.setTabTextColors(Color.GRAY,myColor);
        homePageTl.setSelectedTabIndicatorColor(myColor);
        homePageTl.setTabMode (TabLayout.MODE_SCROLLABLE);

        homePageTl.getTabAt(0).setText("拨号");
        for (int i = 1; i <18 ; i++) {
           homePageTl.getTabAt(i).setText("更多");
        }

    }
}
