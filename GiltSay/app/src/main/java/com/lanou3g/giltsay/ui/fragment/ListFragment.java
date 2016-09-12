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
public class ListFragment extends AbsBaseFragment{
    public static final int myColor       = 0xFFFF0033;
    private TabLayout listTl;
    private ViewPager listVp;

    public static ListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initViews() {
        listTl = byView(R.id.list_tl);
        listVp = byView(R.id.list_vp);

    }

    @Override
    protected void initDatas() {
        List<Fragment>datas = new ArrayList<>();
        datas.add(ListTabNormalFragment.newInstance());
        datas.add(ListTabNormalFragment.newInstance());
        datas.add(ListTabNormalFragment.newInstance());
        datas.add(ListTabNormalFragment.newInstance());
        PagerAdapter listTabAdapter = new PagerAdapter(getChildFragmentManager(),datas);
        listVp.setAdapter(listTabAdapter);
        listTl.setupWithViewPager(listVp);
        listTl.setTabTextColors(Color.GRAY,myColor);
        listTl.getTabAt(0).setText("每日推荐");
        listTl.getTabAt(1).setText("TOP100");
        listTl.getTabAt(2).setText("独立原创榜");
        listTl.getTabAt(3).setText("新星榜");

    }
}
