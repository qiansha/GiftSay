package com.lanou3g.giltsay.ui.fragment.homepagefragment;

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
 */
public class BigImgFragmentActivity extends AbsBaseActivity implements VolleyResult {

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
        String url = intent.getStringExtra("url");
        VolleyInstance.getInstance().startRequest(url,this);


    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        HomeSeleHorRvBean bean = gson.fromJson(resultStr,HomeSeleHorRvBean.class);
        List<HomeSeleHorRvBean.DataBean.SecondaryBannersBean>banBean = bean.getData().getSecondary_banners();
        Picasso.with(getBaseContext()).load(banBean.get(1).getImage_url()).into(bigImg);

    }

    @Override
    public void failure() {

    }
}
