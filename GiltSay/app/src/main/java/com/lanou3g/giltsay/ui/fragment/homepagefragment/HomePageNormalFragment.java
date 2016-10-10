package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.activity.HomePageDetailActivity;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.lanou3g.giltsay.view.ReFlashListView;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 首页的其他分页面
 */
public class HomePageNormalFragment extends AbsBaseFragment implements VolleyResult, ReFlashListView.OnLoadListener, ReFlashListView.OnRefreshListener {

    private ReFlashListView homeNormalListView;
    private String tag;
    private HomeSeleLvAdapter homeSeleLvAdapter;

    public static HomePageNormalFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        HomePageNormalFragment fragment = new HomePageNormalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage_normal;
    }

    @Override
    protected void initViews() {
        homeNormalListView = byView(R.id.homepage_normal_lv);
    }

    @Override
    protected void initDatas() {
        homeNormalListView.setOnLoadListener(this);
        homeNormalListView.setOnRefreshListener(this);
        Bundle bundle = getArguments();
        this.tag = bundle.getString("url");
        homeSeleLvAdapter = new HomeSeleLvAdapter(getContext());
        homeNormalListView.setAdapter(homeSeleLvAdapter);
        VolleyInstance.getInstance().startRequest(tag, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        final HomeSeleBean homeSeleBean = gson.fromJson(resultStr, HomeSeleBean.class);
        List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();
        homeSeleLvAdapter.setDatas(homeSeleBeanData);
        /**
         * 点击ListView行布局跳转
         */
        homeNormalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, HomePageDetailActivity.class);
                int been = homeSeleBean.getData().getItems().get(position).getId();
                String imgUrl = homeSeleBean.getData().getItems().get(position).getCover_image_url();
                intent.putExtra("id", been);
                intent.putExtra("imgUrl", imgUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    public void failure() {

    }

    @Override
    public void onLoad() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                homeNormalListView.onRefreshComplete();
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                homeNormalListView.onRefreshComplete();
            }
        }, 2000);

    }
}
