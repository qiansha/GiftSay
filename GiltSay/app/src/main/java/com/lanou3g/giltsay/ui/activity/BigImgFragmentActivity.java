package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleHorRvBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.activity.AbsBaseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/26.
 * RecyclerView图片放大的Activity
 */
public class BigImgFragmentActivity extends AbsBaseActivity implements VolleyResult {
    private int position;
    private String url;
    private ImageView bigImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_home_bigimg;
    }

    @Override
    protected void initViews() {
        bigImg = byView(R.id.homepage_bigimg_img);

    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        position = intent.getIntExtra("position", 0);
        VolleyInstance.getInstance().startRequest(url,this);
    }

    @Override
    public void success(String resultStr) {
        Picasso.with(getBaseContext()).load(url).into(bigImg);
    }

    @Override
    public void failure() {

    }
}
