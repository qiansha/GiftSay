package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListDetailBean;
import com.lanou3g.giltsay.model.bean.ListPageRecyclerViewBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.ListDetailSingleRvAdapter;
import com.lanou3g.giltsay.ui.adapter.ListPageRvAdapter;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/10/9.
 * 分类单品详情页面
 */
public class ClassSingleDetailActivity extends AbsBaseActivity implements VolleyResult {
    private ListPageRvAdapter RvAdapter;
    private RecyclerView singleRv;
    private ImageView backImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_class_single_detail;
    }

    @Override
    protected void initViews() {
        singleRv = byView(R.id.list_detail_single_rv);
        backImg = byView(R.id.class_single_detail_back_img);

    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        String url = StaticClassHelper.classSingleStartUrl + id + StaticClassHelper.classSingleEndUrl;
        Log.d("ClassSingleDetailActivi", url);
        VolleyInstance.getInstance().startRequest(url,this);
        RvAdapter = new ListPageRvAdapter(this);
        GridLayoutManager gm = new GridLayoutManager(this, 2);
        singleRv.setLayoutManager(gm);
        singleRv.setAdapter(RvAdapter);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListPageRecyclerViewBean listPageRecyclerViewBean = gson.fromJson(resultStr, ListPageRecyclerViewBean.class);
        final List<ListPageRecyclerViewBean.DataBean.ItemsBean> itemsBeanListData = listPageRecyclerViewBean.getData().getItems();

        RvAdapter.setDatas(itemsBeanListData);
    }

    @Override
    public void failure() {

    }
}
