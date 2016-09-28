package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.activity.SignInActivity;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 榜单总页面
 */
public class ListFragment extends AbsBaseFragment {

    private TabLayout listTl;
    private ViewPager listVp;
    private String url;
    private ImageView moreImg;

    public static ListFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
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
        moreImg = byView(R.id.list_more_img);
    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");
        List<Fragment> datas = new ArrayList<>();
        datas.add(ListTabNormalFragment.newInstance(StaticClassHelper.listSuggestUrl));
        datas.add(ListTabNormalFragment.newInstance(StaticClassHelper.listTopUrl));
        datas.add(ListTabNormalFragment.newInstance(StaticClassHelper.listOneUrl));
        datas.add(ListTabNormalFragment.newInstance(StaticClassHelper.listNewStarUrl));
        MainPagerAdapter listTabAdapter = new MainPagerAdapter(getChildFragmentManager(), datas);
        listVp.setAdapter(listTabAdapter);
        listTl.setupWithViewPager(listVp);
        listTl.setTabTextColors(Color.GRAY, StaticClassHelper.myColor);
        listTl.getTabAt(0).setText("每日推荐");
        listTl.getTabAt(1).setText("TOP100");
        listTl.getTabAt(2).setText("独立原创榜");
        listTl.getTabAt(3).setText("新星榜");

        /**
         * 标题栏图片点击事件
         */
        moreImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignInActivity.class);
                startActivity(intent);
            }
        });

    }
}
