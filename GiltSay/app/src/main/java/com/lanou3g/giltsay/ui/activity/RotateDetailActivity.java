package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.model.bean.RotateDetailBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.ui.adapter.RotateDetailAdapter;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 * 轮播图详情
 */
public class RotateDetailActivity extends AbsBaseActivity implements VolleyResult, View.OnClickListener {
    private ImageView backImg;
    private ImageView shareImg;
    private TextView titleTv;
    private RotateDetailAdapter rotateDetailAdapter;
    private List<RotateDetailBean.DataBean.PostsBean> bean;
    private ListView detailLv;
    private String url;

    @Override
    protected int setLayout() {
        return R.layout.activity_rotate_detail;
    }

    @Override
    protected void initViews() {
        detailLv = byView(R.id.rotate_detail_lv);
        backImg = byView(R.id.rotate_detail_back_img);
        shareImg = byView(R.id.rotate_detail_share_img);
        titleTv = byView(R.id.rotate_detail_title_tv);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("target_id");
        Log.d("xxx", id);
        id = id.substring(0, id.lastIndexOf('.'));
        Log.d("xxx", id);
        url = StaticClassHelper.rotateDetailIdStartUrl + id + StaticClassHelper.rotateDetailIdEndUrl;
        rotateDetailAdapter = new RotateDetailAdapter(getBaseContext());
        VolleyInstance.getInstance().startRequest(url, this);
        Log.d("xxx", url);
        //返回和分享的点击事件
        backImg.setOnClickListener(this);
        shareImg.setOnClickListener(this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        RotateDetailBean rotateDetailBean = gson.fromJson(resultStr, RotateDetailBean.class);
        bean = rotateDetailBean.getData().getPosts();
        String title = rotateDetailBean.getData().getTitle();
        detailLv.setAdapter(rotateDetailAdapter);
        rotateDetailAdapter.setDatas(bean);
        titleTv.setText(title);

    }

    @Override
    public void failure() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rotate_detail_back_img:
                finish();
                break;
            case R.id.rotate_detail_share_img:
                Intent intent = new Intent(RotateDetailActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
        }
    }
}
