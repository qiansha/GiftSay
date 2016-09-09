package com.lanou3g.giltsay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * Fragment的适配器
 */
public class PagerAdapter extends FragmentPagerAdapter{
    private List<Fragment>fragments;
    public PagerAdapter(FragmentManager fm,List<Fragment>fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
