package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;

import com.android.volley.toolbox.StringRequest;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/27.
 */
public class HomepageDetailFragment extends AbsBaseFragment{
    private String url;
    public static HomepageDetailFragment newInstance(String url) {

        
        Bundle args = new Bundle();
        args.putString("url",url);
        HomepageDetailFragment fragment = new HomepageDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage_detail;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        this.url = bundle.getString("url");


    }
}
