package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListPageRecyclerViewBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.ListPageRvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.lanou3g.giltsay.model.bean.ListPageRecyclerViewBean.*;
import static com.lanou3g.giltsay.model.bean.ListPageRecyclerViewBean.DataBean.*;

/**
 * Created by dllo on 16/9/9.
 * 榜单中分页面
 */
public class ListTabNormalFragment extends AbsBaseFragment implements VolleyResult {
    private ListPageRvAdapter listPageRvAdapter;
    private ImageView topImg;
    private String url;
    private String datasImg;

    private RecyclerView recyclerView;
    public static ListTabNormalFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);
        ListTabNormalFragment fragment = new ListTabNormalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_list_tab_normal;
    }

    @Override
    protected void initViews() {
        recyclerView  = byView(R.id.listpage_rv);
        topImg = byView(R.id.listpage_top_img);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");
//        VolleyInstance.getInstance().startRequest(topUrl,this);
        listPageRvAdapter = new ListPageRvAdapter(context);
        recyclerView.setAdapter(listPageRvAdapter);
//        VolleyInstance.getInstance().startRequest(url, new VolleyResult() {
//            @Override
//            public void success(String resultStr) {
//
//            }
//
//            @Override
//            public void failure() {
//
//            }
//        });
        VolleyInstance.getInstance().startRequest(url,this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListPageRecyclerViewBean listPageRecyclerViewBean = gson.fromJson(resultStr,ListPageRecyclerViewBean.class);
        List<ListPageRecyclerViewBean.DataBean.ItemsBean>itemsBeanListData = listPageRecyclerViewBean.getData().getItems();

        listPageRvAdapter.setDatas(itemsBeanListData);

        GridLayoutManager glm = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(glm);
        datasImg = listPageRecyclerViewBean.getData().getCover_image();
                Picasso.with(context).load(datasImg).fit().into(topImg);
    }

    @Override
    public void failure() {

    }
}
