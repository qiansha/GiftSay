package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListDetaliHTMLBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/28.
 */
public class ListDEtailSingleFragment extends AbsBaseFragment implements VolleyResult {
    private String url;
    private WebView singleWv;
    public static ListDEtailSingleFragment newInstance(String url) {
        
        Bundle args = new Bundle();
        args.putString("url",url);
        ListDEtailSingleFragment fragment = new ListDEtailSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_list_detail_tab_single;
    }

    @Override
    protected void initViews() {
        singleWv = byView(R.id.list_detail_single_wv);


    }

    @Override
    protected void initDatas() {
        Bundle bundler = getArguments();
        this.url = bundler.getString("url");
        VolleyInstance.getInstance().startRequest(url,this);
        Log.d("sisisi", url);

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListDetaliHTMLBean bean = gson.fromJson(resultStr,ListDetaliHTMLBean.class);
        singleWv.loadUrl(bean.getData().getUrl());

    }

    @Override
    public void failure() {

    }
}
