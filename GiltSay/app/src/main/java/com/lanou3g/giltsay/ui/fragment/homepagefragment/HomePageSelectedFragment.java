package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeRotateBean;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;

import com.lanou3g.giltsay.model.bean.HomeSeleHorRvBean;
import com.lanou3g.giltsay.model.bean.HomeSeleRvBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.activity.BigImgFragmentActivity;
import com.lanou3g.giltsay.ui.activity.HomePageDetailActivity;
import com.lanou3g.giltsay.ui.adapter.HomePageSelectedRvAdapter;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.adapter.HomeSeleRotateAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.Calendar;
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
    private TextView homeHeadTimeTv2;
    private int month;
    private int day;
    private int newTime;
    private String weekDay;
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
        pointLl = byView(R.id.homepage_sele_rotate_point_ll);
        homeSeleListView = byView(R.id.homepage_selected_lv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");
        VolleyInstance.getInstance().startRequest(url, this);//轮播图和ListView网络请求

        /**
         * 加头布局
         */
        View headView = getActivity().getLayoutInflater().inflate(R.layout.head_home_sele, null);
        rotateViewPager = (ViewPager) headView.findViewById(R.id.homepage_sele_rotate_vp);
        homeSeleRecyclerView = (RecyclerView) headView.findViewById(R.id.homepage_selected_rv);
        homeHeadTimeTv1 = (TextView) headView.findViewById(R.id.home_sele_time_tv1);
        homeHeadTimeTv2 = (TextView) headView.findViewById(R.id.home_sele_time_tv2);
        pointLl = (LinearLayout) headView.findViewById(R.id.homepage_sele_rotate_point_ll);
        /**
         * 添加轮播图头布局
         */
        //轮播图
        buildDatas();
        homeSeleRotateAdapter = new HomeSeleRotateAdapter(reDatas, context);
        rotateViewPager.setAdapter(homeSeleRotateAdapter);
        rotateViewPager.setCurrentItem(reDatas.size() * 100);
        /**
         * 轮播图点击事件
         */
        rotateViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Intent intent = new Intent(context,HomePageDetailActivity.class);
                        intent.putExtra("id","111");
                        intent.putExtra("imgUrl","");
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });


        //开始轮播
        handler = new Handler();
        startRotate();
//        添加轮播小点
        addPoints();
        //    随着轮播改变小点
        changePoints();
        /**
         * 横向RecyclerView
         */
        addRvHeadView();

        /**
         * 时间
         */
        /**
         * 时间的设置
         */
        settingTime();
        int newMonth = month + 1;
        homeHeadTimeTv1.setText(newMonth + "月" + day + "日" + " " + "星期" + weekDay);
        homeHeadTimeTv2.setText("下次更新 8:00");
        homeHeadTimeTv2.setTextColor(StaticClassHelper.myColor);
    }

    /**
     * 时间
     */
    private void settingTime() {
        Calendar calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        newTime = calendar.get(Calendar.DAY_OF_WEEK);
        switch (newTime) {
            case 1:
                weekDay = "一";
                break;
            case 2:
                weekDay = "二";
                break;
            case 3:
                weekDay = "三";

                break;
            case 4:
                weekDay = "四";
                break;
            case 5:
                weekDay = "五";
                break;
            case 6:
                weekDay = "六";
                break;
            case 7:
                weekDay = "日";
                break;
        }
        Log.d("time", "month:" + month);
        Log.d("time", "day:" + day);
        Log.d("time", "newTime:" + newTime);
    }

    private void addRvHeadView() {
        homePageSelectedRvAdapter = new HomePageSelectedRvAdapter(context);
        homeSeleRecyclerView.setAdapter(homePageSelectedRvAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        homeSeleRecyclerView.setLayoutManager(llm);
        VolleyInstance.getInstance().startRequest(StaticClassHelper.horRecyclerViewUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                final HomeSeleHorRvBean homeSeleHorRvBean = gson.fromJson(resultStr, HomeSeleHorRvBean.class);
                List<HomeSeleHorRvBean.DataBean.SecondaryBannersBean> bannersBeen = homeSeleHorRvBean.getData().getSecondary_banners();
                homePageSelectedRvAdapter.setDatas(bannersBeen);

                /**
                 * RecyclerView点击变大
                 */

                    homePageSelectedRvAdapter.setRecyclerViewItemClick(new RecyclerViewItemClick() {
                        @Override
                        public void onRvItemClickListener(int position, String str) {
                            Intent intent = new Intent(context,BigImgFragmentActivity.class);
                            String bigUrl = homeSeleHorRvBean.getData().getSecondary_banners().get(position).getImage_url();
                            Log.d("bibibi", bigUrl);

                            intent.putExtra("url",bigUrl);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }
                    });
                }
            @Override
            public void failure() {

            }


        });
    }


    private void changePoints() {
        rotateViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    for (int i = 0; i < reDatas.size(); i++) {
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
         final HomeSeleBean homeSeleBean = gson.fromJson(resultStr, HomeSeleBean.class);
        List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();
        homeSeleLvAdapter = new HomeSeleLvAdapter(getContext());
        homeSeleListView.setAdapter(homeSeleLvAdapter);
        homeSeleLvAdapter.setDatas(homeSeleBeanData);

        /**
         * 点击ListView行布局跳转
         */
        homeSeleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, HomePageDetailActivity.class);
                int been = homeSeleBean.getData().getItems().get(position-5).getId();
                Log.d("ididid", "been:" + been);
                String imgUrl = homeSeleBean.getData().getItems().get(position-5).getCover_image_url();
                intent.putExtra("id",been);
                intent.putExtra("imgUrl",imgUrl);
                startActivity(intent);
            }
        });

        /**
         * 添加头布局
         */
        homeSeleListView.addHeaderView(rotateViewPager,null,true); // 轮播图
        homeSeleListView.addHeaderView(pointLl,null,true);//小点
        homeSeleListView.addHeaderView(homeSeleRecyclerView,null,true);// 横图片
        homeSeleListView.addHeaderView(homeHeadTimeTv1,null,true);// 更新
        homeSeleListView.addHeaderView(homeHeadTimeTv2,null,true);
        homeSeleListView.setHeaderDividersEnabled(false);
        Log.d("zzz", resultStr);
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
