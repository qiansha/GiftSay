package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeRotateBean;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;

import com.lanou3g.giltsay.model.bean.HomeSeleRvBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.HomePageSelectedRvAdapter;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.adapter.HomeSeleRotateAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.lanou3g.giltsay.view.ChildViewPager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/9.
 * 首页的精选页面
 */
public class HomePageSelectedFragment extends AbsBaseFragment implements VolleyResult {
    private static final int TIME = 3000;
//    private ChildViewPager rotateViewPager;
    private TextView homeHeadTimeTv1;
    private ViewPager rotateViewPager;
    private LinearLayout pointLl;
    private List<HomeSeRotateBean> reDatas;
    private HomeSeleRotateAdapter homeSeleRotateAdapter;
    private ListView homeSeleListView;
    private RecyclerView homeSeleRecyclerView;
    private HomePageSelectedRvAdapter homePageSelectedRvAdapter;
    private List<HomeSeleRvBean> datas;
    private String url;
    private HomeSeleLvAdapter homeSeleLvAdapter;
    public static HomePageSelectedFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
        HomePageSelectedFragment fragment = new HomePageSelectedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage_selected;
    }

    @Override
    protected void initViews() {
//        rotateViewPager = byView(R.id.homepage_sele_rotate_vp);
        pointLl = byView(R.id.homepage_sele_rotate_point_ll);
//        homeSeleRecyclerView = byView(R.id.homepage_selected_rv);
        homeSeleListView = byView(R.id.homepage_selected_lv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");
        VolleyInstance.getInstance().startRequest(url, this);


        /**
         * 加头布局
         */
        View headView = getActivity().getLayoutInflater().inflate(R.layout.head_home_sele,null);
        rotateViewPager = (ViewPager) headView.findViewById(R.id.homepage_sele_rotate_vp);
        homeSeleRecyclerView = (RecyclerView) headView.findViewById(R.id.homepage_selected_rv);
        homeHeadTimeTv1 = (TextView) headView.findViewById(R.id.home_sele_time_tv1);
        pointLl = (LinearLayout) headView.findViewById(R.id.homepage_sele_rotate_point_ll);



        //轮播图
        buildDatas();
        homeSeleRotateAdapter = new HomeSeleRotateAdapter(reDatas,context);
        rotateViewPager.setAdapter(homeSeleRotateAdapter);
        rotateViewPager.setCurrentItem(reDatas.size() * 100);

        //开始轮播
        handler = new Handler();
        startRotate();
//        添加轮播小点
        addPoints();
        //    随着轮播改变小点
        changePoints();

        datas = new ArrayList<>();
        homePageSelectedRvAdapter = new HomePageSelectedRvAdapter(context);
        homeSeleRecyclerView.setAdapter(homePageSelectedRvAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        homeSeleRecyclerView.setLayoutManager(llm);
        for (int i = 0; i < 17; i++) {
            HomeSeleRvBean hb = new HomeSeleRvBean();
            hb.setImg(R.mipmap.abc_ab_bottom_solid_dark_holo9);
            datas.add(hb);
        }
        homePageSelectedRvAdapter.setDatas(datas);




    }

    private void changePoints() {
        rotateViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate){
                    for (int i = 0; i <reDatas.size() ; i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.abc_ab_bottom_solid_light_holo9);
                    }
                    ImageView iv = (ImageView) pointLl.getChildAt(position % reDatas.size());
                    iv.setImageResource(R.mipmap.abc_ab_bottom_solid_dark_holo9);
                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoints() {
        for (int i = 0; i < reDatas.size(); i++) {
            CircleImageView pointIv = new CircleImageView(context);
            pointIv.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            pointIv.setLayoutParams(params);

            if (i == 0) {
                pointIv.setImageResource(R.mipmap.abc_ab_bottom_solid_dark_holo9);
            } else {
                pointIv.setImageResource(R.mipmap.abc_ab_bottom_solid_light_holo9);
            }
            pointLl.addView(pointIv);

        }
    }

    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;

    private void startRotate() {
        rotateRunnable = new Runnable() {

            @Override
            public void run() {
                int nowIndex = rotateViewPager.getCurrentItem();
                rotateViewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);

                }

            }
        };
        handler.postDelayed(rotateRunnable, TIME);
    }



    private void buildDatas() {
        reDatas = new ArrayList<>();
        reDatas.add(new HomeSeRotateBean(StaticClassHelper.rotateImgUrl1));
        reDatas.add(new HomeSeRotateBean(StaticClassHelper.rotateImgUrl2));
        reDatas.add(new HomeSeRotateBean(StaticClassHelper.rotateImgUrl3));
        reDatas.add(new HomeSeRotateBean(StaticClassHelper.rotateImgUrl4));

    }


    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        HomeSeleBean homeSeleBean = gson.fromJson(resultStr, HomeSeleBean.class);
        List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();
        homeSeleLvAdapter = new HomeSeleLvAdapter(getContext());
        homeSeleListView.setAdapter(homeSeleLvAdapter);
        homeSeleLvAdapter.setDatas(homeSeleBeanData);



//        addRotateView();
        // 轮播图
        homeSeleListView.addHeaderView(rotateViewPager);
        //小点
        homeSeleListView.addHeaderView(pointLl);
        // 横图片
        homeSeleListView.addHeaderView(homeSeleRecyclerView);
        // 更新
        homeSeleListView.addHeaderView(homeHeadTimeTv1);
        Log.d("zzz", resultStr);
    }

    private void addRotateView() {
        datas = new ArrayList<>();
        homePageSelectedRvAdapter = new HomePageSelectedRvAdapter(getContext());
        homeSeleRecyclerView.setAdapter(homePageSelectedRvAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        homeSeleRecyclerView.setLayoutManager(llm);
        for (int i = 0; i < 17; i++) {
            HomeSeleRvBean hb = new HomeSeleRvBean();
            hb.setImg(R.mipmap.abc_ab_bottom_solid_dark_holo9);
            datas.add(hb);
        }
        homePageSelectedRvAdapter.setDatas(datas);


        //轮播图
        buildDatas();
        homeSeleRotateAdapter = new HomeSeleRotateAdapter(reDatas,context);
        rotateViewPager.setAdapter(homeSeleRotateAdapter);
        rotateViewPager.setCurrentItem(reDatas.size() * 100);

        //开始轮播
        handler = new Handler();
        startRotate();
//        添加轮播小点
        addPoints();
//        随着轮播改变小点
        changePoints();
    }

    @Override
    public void failure() {

    }
    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }

}
