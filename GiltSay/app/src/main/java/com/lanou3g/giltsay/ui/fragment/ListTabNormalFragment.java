package com.lanou3g.giltsay.ui.fragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/9/9.
 */
public class ListTabNormalFragment extends AbsBaseFragment{
    public static ListTabNormalFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ListTabNormalFragment fragment = new ListTabNormalFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_list_tab_normal;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
