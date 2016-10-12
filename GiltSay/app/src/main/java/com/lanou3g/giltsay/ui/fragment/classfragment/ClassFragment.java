package com.lanou3g.giltsay.ui.fragment.classfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.activity.SearchDetailActivity;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 分类页面
 */
public class ClassFragment extends AbsBaseFragment {
    private TabLayout classTl;
    private ViewPager classVp;
    private TextView searchTv;

    public static ClassFragment newInstance() {

        Bundle args = new Bundle();

        ClassFragment fragment = new ClassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initViews() {
        classTl = byView(R.id.class_tl);
        classVp = byView(R.id.class_vp);
        searchTv = byView(R.id.class_search_tv);
    }

    @Override
    protected void initDatas() {
        List<Fragment> datas = new ArrayList<>();
        datas.add(ClassTabGuidesFragment.newInstance(StaticClassHelper.classColumnUrl));
        datas.add(ClassTabSingleFragment.newInstance());
        MainPagerAdapter classAdapter = new MainPagerAdapter(getChildFragmentManager(), datas);
        classVp.setAdapter(classAdapter);
        classTl.setupWithViewPager(classVp);
        classTl.setSelectedTabIndicatorColor(Color.WHITE);

        classTl.setTabTextColors(Color.WHITE, Color.rgb(245, 245, 224));
        classTl.getTabAt(0).setText("攻略");
        classTl.getTabAt(1).setText("单品");
        /**
         * 搜索栏点击事件
         */
        searchTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
