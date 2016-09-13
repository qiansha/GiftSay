package com.lanou3g.giltsay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.lanou3g.giltsay.ui.adapter.HomePageSelectedRvAdapter;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class HomePageSelectedFragment extends AbsBaseFragment{
    private ListView homeSeleListView;
    private RecyclerView homeSeleRecyclerView;
    private HomePageSelectedRvAdapter homePageSelectedRvAdapter;
    private List<HomeSeleRvBean>datas;
    private List<HomeSeleLvBean>lvDatas;
    private HomeSeleLvAdapter homeSeleLvAdapter;
    private String seleUrl = "http://api.liwushuo.com/v2/banners?channel=IOS";
    private RequestQueue queue;
    public static HomePageSelectedFragment newInstance() {
        
        Bundle args = new Bundle();
        
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
        queue = Volley.newRequestQueue(getActivity());


    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        homePageSelectedRvAdapter = new HomePageSelectedRvAdapter(getContext());
        homeSeleRecyclerView.setAdapter(homePageSelectedRvAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        homeSeleRecyclerView.setLayoutManager(llm);
        for (int i = 0; i < 17; i++) {
           HomeSeleRvBean hb = new HomeSeleRvBean();
            hb.setImg(R.mipmap.abc_ab_bottom_solid_dark_holo9);
            datas.add(hb);
        }

        homePageSelectedRvAdapter.setDatas(datas);
//
//        lvDatas = new ArrayList<>();

//        List<HomeSeleLvBean>lb = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            lb.add(new HomeSeleLvBean("礼物","描述","作者","标题","点赞数"));
//
//        }
//        homeSeleLvAdapter.setDatas(lb);

        StringRequest sr = new StringRequest(seleUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HomeSeleBean homeSeleBean = gson.fromJson(response,HomeSeleBean.class);
                List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData =  homeSeleBean.getData().getItems();
//                Log.d("HomePageSelectedFragmen", "homeSeleBeanData.get(0).getColumn():" + homeSeleBeanData.get);
//                Log.d("HomePageSelectedFragmen", homeSeleBeanData.get(1).getTitle());
//                for (int i = 0; i < homeSeleBeanData.size(); i++) {
//                    Log.d("HomePageSelectedFragmen", null);
//                }
                homeSeleLvAdapter = new HomeSeleLvAdapter(getContext());
                homeSeleListView.setAdapter(homeSeleLvAdapter);
                homeSeleLvAdapter.setDatas(homeSeleBeanData);
                Log.d("zzz", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);

    }


}
