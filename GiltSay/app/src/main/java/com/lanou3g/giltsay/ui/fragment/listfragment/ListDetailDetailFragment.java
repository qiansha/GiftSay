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
 * 榜单详情中详情页面Fragment
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
