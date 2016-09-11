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
public class PersonFragment extends AbsBaseFragment{
    private static final int myColor = 0XFFFF0033;
    private TabLayout personTl;
    private ViewPager personVp;
    private List<Fragment>datas;
    @Override
    protected int setLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        personTl = byView(R.id.person_tl);
        personVp = byView(R.id.person_vp);


    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        datas.add(new PersonTabGuidesFragment());
        datas.add(new PersonTabSingleFragment());
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(),datas);
        personVp.setAdapter(pagerAdapter);
        personTl.setupWithViewPager(personVp);
        personTl.setTabTextColors(Color.BLACK,Color.BLACK);
        personTl.setSelectedTabIndicatorColor(myColor);
        personTl.getTabAt(0).setText("攻略");
        personTl.getTabAt(1).setText("单品");

    }
}
