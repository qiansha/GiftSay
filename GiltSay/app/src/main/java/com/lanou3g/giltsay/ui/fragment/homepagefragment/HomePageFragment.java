package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;


import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomePopRvBean;
import com.lanou3g.giltsay.ui.adapter.HomePagePopRvAdapter;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 首页页面
 */
public class HomePageFragment extends AbsBaseFragment {
    private ImageView popImg;
    private HomePagePopRvAdapter homePopAdapter;
    private RecyclerView homePopRecyclerView;
    private List<String>data;

    private String[] popStr = {"精选","送男票", "穿搭", "海淘", "礼物", "美护", "送闺蜜", "送爸妈",
            "送基友", "送同事", "送宝贝", "创意生活", "手工", "设计感", "文艺风", "科技范", "奇葩搞怪", "萌萌哒"};


    private TabLayout homePageTl;
    private ViewPager homePageVp;

    public static HomePageFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);
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
        popImg = byView(R.id.homepage_pop_img);



    }

    @Override
    protected void initDatas() {
        List<Fragment> datas = new ArrayList<>();


        datas.add(HomePageSelectedFragment.newInstance(StaticClassHelper.homeSeleUrl));

            datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeNorSendBoyFriend));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homrOutFitUrl));
        for (int i = 0; i < 15; i++) {
            datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeNorSendBoyFriend));

        }



        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), datas);
        homePageVp.setAdapter(mainPagerAdapter);
        homePageTl.setupWithViewPager(homePageVp);
        homePageTl.setSelectedTabIndicatorHeight(3);
        homePageTl.setTabTextColors(Color.GRAY, StaticClassHelper.myColor);
        homePageTl.setSelectedTabIndicatorColor(StaticClassHelper.myColor);
        homePageTl.setTabMode(TabLayout.MODE_SCROLLABLE);

        homePageTl.getTabAt(0).setText("精选");
        String[] str = {"送男票", "穿搭", "海淘", "礼物", "美护", "送闺蜜", "送爸妈",
                "送基友", "送同事", "送宝贝", "创意生活", "手工", "设计感", "文艺风", "科技范", "奇葩搞怪", "萌萌哒"};
        for (int i = 1; i < 18; i++) {
            homePageTl.getTabAt(i).setText(str[i - 1]);
        }
        popImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPop();
            }
        });



    }

    private void createPop() {
        PopupWindow homePop = new PopupWindow(context);
        homePop.setWidth(ViewPager.LayoutParams.MATCH_PARENT);
        homePop.setHeight(ViewPager.LayoutParams.WRAP_CONTENT);
        View v = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_pop,null);
        homePopRecyclerView = (RecyclerView) v.findViewById(R.id.home_pop_recyclerview);
        homePop.setContentView(v);
        //给PopWindow加数据
        homePopAdapter = new HomePagePopRvAdapter(context);
        homePopRecyclerView.setAdapter(homePopAdapter);
        GridLayoutManager gm = new GridLayoutManager(context,4);
        homePopRecyclerView.setLayoutManager(gm);
        data = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            data.add(popStr[i]);

        }

        homePopAdapter.setDatas(data);
        homePop.setOutsideTouchable(true);
        homePop.showAsDropDown(homePageTl);
    }
}
