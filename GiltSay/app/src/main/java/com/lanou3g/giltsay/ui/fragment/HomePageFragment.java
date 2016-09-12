package com.lanou3g.giltsay.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
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

    public static HomePageFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }
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



        datas.add(HomePageSelectedFragment.newInstance());
        for (int i = 0; i < 17; i++) {
            datas.add(HomePageNormalFragment.newInstance());
        }



        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(),datas);
        homePageVp.setAdapter(pagerAdapter);
        homePageTl.setupWithViewPager(homePageVp);
        homePageTl.setSelectedTabIndicatorHeight(3);
        homePageTl.setTabTextColors(Color.GRAY,myColor);
        homePageTl.setSelectedTabIndicatorColor(myColor);
        homePageTl.setTabMode (TabLayout.MODE_SCROLLABLE);

        homePageTl.getTabAt(0).setText("推荐");
        String[]str = {"送男票","穿搭","海淘","礼物","美护","送闺蜜","送爸妈",
                "送基友","送同事","送宝贝","创意生活","手工","设计感","文艺风","科技范","奇葩搞怪","萌萌哒"};
        for (int i = 1; i <18 ; i++) {
           homePageTl.getTabAt(i).setText(str[i-1]);
        }

    }
}
