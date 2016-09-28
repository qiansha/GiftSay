package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeDetailBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/27.
 * 首页详情Activity
 */
public class HomePageDetailActivity extends AbsBaseActivity implements VolleyResult, View.OnClickListener {
    private WebView detailWv;
    private ImageView detailImg;
    private String imgUrl;
    private TextView likeCountTv;
    private TextView sharedTv;
    private TextView talkAboutTv;
    private ImageView goBackImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_homepage_detail;
    }

    @Override
    protected void initViews() {
        detailWv = byView(R.id.home_detail_wv);
        likeCountTv = byView(R.id.home_detail_like_count_tv);
        sharedTv = byView(R.id.home_detail_zhuanfa_tv);
        talkAboutTv = byView(R.id.home_detail_talk_count_tv);
        goBackImg = byView(R.id.home_detail_goback_img);


    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        int itemId = intent.getIntExtra("id", 0);
        imgUrl = intent.getStringExtra("imgUrl");
        Log.d("dedede", "itemId:" + itemId);
        Log.d("dedede", imgUrl);
        String url = StaticClassHelper.homeSeleDetailsUrl + itemId;
        Log.d("url", url);
        detailWv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        });
//        WebSettings set = detailWv.getSettings();
//        set.setJavaScriptEnabled(true);
////        // 让JavaScript可以自动打开windows
//        set.setJavaScriptCanOpenWindowsAutomatically(true);
//        // 设置缓存
//        set.setAppCacheEnabled(true);
//        // 设置缓存模式,一共有四种模式
//        set.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        // 设置缓存路径
////        webSettings.setAppCachePath("");
//        // 支持缩放(适配到当前屏幕)
//        set.setSupportZoom(true);
////        // 将图片调整到合适的大小
//        set.setUseWideViewPort(true);
//        // 支持内容重新布局,一共有四种方式
//        // 默认的是NARROW_COLUMNS
//        set.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        // 设置可以被显示的屏幕控制
//        set.setDisplayZoomControls(true);
        VolleyInstance.getInstance().startRequest(url, this);
        /**
         * 返回前一页
         */
        goBackImg.setOnClickListener(this);

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        HomeDetailBean homeDetailBean = gson.fromJson(resultStr, HomeDetailBean.class);
//        String bean = homeDetailBean.getData().getContent_html();
//        detailWv.loadData(bean, "text/html; charset=UTF-8", null);
        detailWv.loadUrl(homeDetailBean.getData().getUrl());
//        Picasso.with(getBaseContext()).load(homeDetailBean.getData().getCover_image_url()).config(Bitmap.Config.RGB_565).into(detailImg);
        int count = homeDetailBean.getData().getLikes_count();
        Log.d("count", "count:" + count);
        likeCountTv.setText(count + "");
        sharedTv.setText(homeDetailBean.getData().getShares_count() + "");


    }

    @Override
    public void failure() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_detail_goback_img:
                finish();
                break;
        }
    }


}
