package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListDetaliHTMLBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/28.
 */
public class ListDetailDetailFragment extends AbsBaseFragment implements VolleyResult {
    private String url;
    private WebView detailWv;
    public static ListDetailDetailFragment newInstance(String str) {
        
        Bundle args = new Bundle();
        args.putString("url",str);
        ListDetailDetailFragment fragment = new ListDetailDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_list_detail_tab_detail;
    }

    @Override
    protected void initViews() {
        detailWv = byView(R.id.list_detail_detail_wv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");
        detailWv.setWebViewClient(new WebViewClient(){
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
        // 设置缓存路径
//        webSettings.setAppCachePath("");
        // 支持缩放(适配到当前屏幕)
//        set.setSupportZoom(true);
//        // 将图片调整到合适的大小
//        set.setUseWideViewPort(true);
//        // 支持内容重新布局,一共有四种方式
//        // 默认的是NARROW_COLUMNS
//        set.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        // 设置可以被显示的屏幕控制
//        set.setDisplayZoomControls(true);
        VolleyInstance.getInstance().startRequest(url,this);


    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListDetaliHTMLBean listDetaliHTMLBean = gson.fromJson(resultStr,ListDetaliHTMLBean.class);
        detailWv.loadData(listDetaliHTMLBean.getData().getDetail_html(),"text/html; charset=UTF-8",null);
    }

    @Override
    public void failure() {

    }
}
