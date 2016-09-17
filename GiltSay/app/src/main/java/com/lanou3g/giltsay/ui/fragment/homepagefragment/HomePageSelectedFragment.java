package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.model.bean.HomeSeleLvBean;
import com.lanou3g.giltsay.model.bean.HomeSeleRvBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.HomePageSelectedRvAdapter;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 首页的精选页面
 */
public class HomePageSelectedFragment extends AbsBaseFragment implements VolleyResult {
    private ListView homeSeleListView;
    private RecyclerView homeSeleRecyclerView;
    private HomePageSelectedRvAdapter homePageSelectedRvAdapter;
    private List<HomeSeleRvBean> datas;
    private String url;
    private List<HomeSeleLvBean> lvDatas;
    private HomeSeleLvAdapter homeSeleLvAdapter;



    public static HomePageSelectedFragment newInstance(String url) {

        Bundle args = new Bundle();
          args.putString("url",url);
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
        homeSeleRecyclerView = byView(R.id.homepage_selected_rv);
        homeSeleListView = byView(R.id.homepage_selected_lv);
    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");
        VolleyInstance.getInstance().startRequest(url, this);
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
    }


    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        HomeSeleBean homeSeleBean = gson.fromJson(resultStr, HomeSeleBean.class);
        List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();
        homeSeleLvAdapter = new HomeSeleLvAdapter(getContext());
        homeSeleListView.setAdapter(homeSeleLvAdapter);
        homeSeleLvAdapter.setDatas(homeSeleBeanData);
        Log.d("zzz", resultStr);
    }

    @Override
    public void failure() {

    }
}
