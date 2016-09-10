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
public class ClassFragment extends AbsBaseFragment{
    private TabLayout classTl;
    private ViewPager classVp;
    @Override
    protected int setLayout() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initViews() {
        classTl = byView(R.id.class_tl);
        classVp = byView(R.id.class_vp);


    }

    @Override
    protected void initDatas() {
        List<Fragment>datas = new ArrayList<>();
        datas.add(new ClassTabGuidesFragment());
        datas.add(new ClassTabSingleFragment());
        PagerAdapter classAdapter = new PagerAdapter(getChildFragmentManager(),datas);
        classVp.setAdapter(classAdapter);
        classTl.setupWithViewPager(classVp);
        classTl.setSelectedTabIndicatorColor(Color.WHITE);

        classTl.setTabTextColors(Color.WHITE,Color.rgb(245,245,224));
        classTl.getTabAt(0).setText("攻略");
        classTl.getTabAt(1).setText("单品");

    }
}
