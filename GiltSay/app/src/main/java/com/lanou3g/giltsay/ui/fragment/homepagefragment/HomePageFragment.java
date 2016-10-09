package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;


import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomePopRvBean;
import com.lanou3g.giltsay.ui.activity.SearchDetailActivity;
import com.lanou3g.giltsay.ui.activity.SignInActivity;
import com.lanou3g.giltsay.ui.adapter.HomePagePopRvAdapter;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.lanou3g.giltsay.utils.StaticClassHelper;


import java.util.ArrayList;
import java.util.List;

import static com.lanou3g.giltsay.utils.StaticClassHelper.seleBgColor;

/**
 * Created by dllo on 16/9/8.
 * 首页页面
 */
public class HomePageFragment extends AbsBaseFragment {
    private PopupWindow homePop;
    private ImageView popImgUp;
    private ImageView popImg;
    private HomePagePopRvAdapter homePopAdapter;
    private RecyclerView homePopRecyclerView;
    private List<String> data;
    private boolean flag = false;
    private TextView homeSearchTv;
    private ImageView homeTopImg;


    private String[] popStr = {"精选", "送男票", "穿搭", "海淘", "礼物", "美护", "送闺蜜", "送爸妈",
            "送基友", "送同事", "送宝贝", "创意生活", "手工", "设计感", "文艺风", "科技范", "奇葩搞怪", "萌萌哒"};


    private TabLayout homePageTl;
    private ViewPager homePageVp;

    public static HomePageFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
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
        homeSearchTv = byView(R.id.home_search_tv);
        homeTopImg = byView(R.id.homepage_top_img);
//        popImgUp = byView(R.id.home_pop_up_img);

    }

    @Override
    protected void initDatas() {
        addTarget();//右上角图标跑的点击事件,搜索栏点击事件
        List<Fragment> datas = new ArrayList<>();
        addDataUrl(datas);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), datas);
        homePageVp.setAdapter(mainPagerAdapter);
        homePageTl.setupWithViewPager(homePageVp);
        homePageTl.setSelectedTabIndicatorHeight(3);
        homePageTl.setTabTextColors(Color.BLACK, StaticClassHelper.myColor);
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

//        popImg.setImageResource(R.mipmap.arrow_grey_down);
        homePopAdapter = new HomePagePopRvAdapter(context);//new适配器要和创建PopWindow分开写

    }

    private void addTarget() {
        /**
         * 右上角图标的点击事件
         */
        Log.d("imimim", "wai");
        homeTopImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignInActivity.class);
                startActivity(intent);
                Log.d("imimim", "图标点击");
            }
        });
        /**
         * 搜索栏点击事件
         */
        homeSearchTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * PopWindow的点击事件
     */
    private void addPopWindowListener(final PopupWindow homePop) {
        homePopAdapter.setRecyclerViewItemClick(new RecyclerViewItemClick() {
            @Override
            public void onRvItemClickListener(int position, String str) {
//                popImg.setImageResource(R.mipmap.arrow_grey_down);
//                popImg.setBackgroundResource(R.mipmap.arrow_grey_down);

                homePageVp.setCurrentItem(position);
                homePopAdapter.setSelectedIndex(position);
//                Log.d("数", "position:" + position+"----");
//                Log.d("HomePageFragment", "homePageVp.getCurrentItem():" + homePageVp.getCurrentItem());
                homePopAdapter.notifyDataSetChanged();

                homePop.dismiss();

//                popImg.setImageResource(R.mipmap.arrow_grey_up);
            }
        });


    }

    private void addDataUrl(List<Fragment> datas) {
        datas.add(HomePageSelectedFragment.newInstance(StaticClassHelper.homeSele1Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeNorSendBoy2Friend));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homrOutFit3Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeHaitao4Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeGift5Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeMeihu6Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeGuimi7Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeSendParents8Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeSendFriend9Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeSendCullgeure10Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeSendBody11Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeChuangyi12Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeShougong13Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeSheji14Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeWenyi15Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeKeji16Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeQipa17Url));
        datas.add(HomePageNormalFragment.newInstance(StaticClassHelper.homeMengmeng18Url));
    }

    private void createPop() {
        homePop = new PopupWindow(context);

        homePop.setWidth(ViewPager.LayoutParams.MATCH_PARENT);
        homePop.setHeight(ViewPager.LayoutParams.WRAP_CONTENT);
        View v = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_pop, null);
        homePopRecyclerView = (RecyclerView) v.findViewById(R.id.home_pop_recyclerview);
        popImgUp = (ImageView) v.findViewById(R.id.home_pop_up_img);
        homePop.setContentView(v);
        homePop.setBackgroundDrawable(null);
        homePop.showAtLocation(popImg, Gravity.NO_GRAVITY, 0, homePageTl.getHeight());
        //给PopWindow加数据

        homePopRecyclerView.setAdapter(homePopAdapter);
        GridLayoutManager gm = new GridLayoutManager(context, 4);
        homePopRecyclerView.setLayoutManager(gm);
        data = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            data.add(popStr[i]);

        }

        homePopAdapter.setDatas(data);
        homePop.setOutsideTouchable(true);
        homePop.showAsDropDown(homePageTl);

        /**
         * 给PopWindow添加点击事件
         */
        addPopWindowListener(homePop);
        popImgUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePop.dismiss();
            }
        });

    }


}
