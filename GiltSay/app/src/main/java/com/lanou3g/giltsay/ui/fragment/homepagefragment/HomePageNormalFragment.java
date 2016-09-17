package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 首页的其他分页面
 */
public class HomePageNormalFragment extends AbsBaseFragment {

    private ListView homeNormalListView;
    private String tag;
    private RequestQueue queue;
    private HomeSeleLvAdapter homeSeleLvAdapter;

    public static HomePageNormalFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);
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
        Bundle bundle = getArguments();
        this.tag = bundle.getString("url");
        queue = Volley.newRequestQueue(getContext());
        homeSeleLvAdapter = new HomeSeleLvAdapter(getContext());
        homeNormalListView.setAdapter(homeSeleLvAdapter);
        StringRequest sr = new StringRequest(tag, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HomeSeleBean homeSeleBean = gson.fromJson(response, HomeSeleBean.class);
                List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();
                homeSeleLvAdapter.setDatas(homeSeleBeanData);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);

    }

}
