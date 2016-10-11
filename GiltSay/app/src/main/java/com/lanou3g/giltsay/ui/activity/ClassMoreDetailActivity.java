package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.app.GiftApp;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.lanou3g.giltsay.view.ReFlashListView;

import java.util.List;

/**
 * Created by dllo on 16/10/8.
 */
public class ClassMoreDetailActivity extends AbsBaseActivity implements VolleyResult, ReFlashListView.OnLoadListener,ReFlashListView.OnRefreshListener, View.OnClickListener {
    private ReFlashListView listView;
    private ImageView backImg;
    private TextView titleTv;
    private HomeSeleLvAdapter lvAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_class_more_detail;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.class_guides_more_detail_lv);
        backImg = byView(R.id.class_guides_more_detail_back_img);
        titleTv = byView(R.id.class_guides_more_detail_title_tv);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String url = StaticClassHelper.classClassDetailStartUrl + id + StaticClassHelper.classClassDetailEndUrl;
        Log.d("moreUrl", url);
        lvAdapter = new HomeSeleLvAdapter(GiftApp.getContext());
        listView.setAdapter(lvAdapter);
//        listView.setInterface(this);
        VolleyInstance.getInstance().startRequest(url, this);
        backImg.setOnClickListener(this);
        listView.setOnRefreshListener(this);
        listView.setOnLoadListener(this);

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        final HomeSeleBean homeSeleBean = gson.fromJson(resultStr, HomeSeleBean.class);
        List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();
        lvAdapter.setDatas(homeSeleBeanData);
        Log.d("ClassMoreDetailActivity", "homeSeleBeanData:" + homeSeleBeanData);
    }

    @Override
    public void failure() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class_guides_more_detail_back_img:
                finish();
                break;
        }
    }

    @Override
    public void onLoad() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.onRefreshComplete();
            }
        }, 2000);

    }

    @Override
    public void onRefresh() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.onRefreshComplete();
            }
        }, 2000);

    }
}
