package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/28.
 */
public class ListDetailDetailFragment extends AbsBaseFragment{
    public static ListDetailDetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
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

    }

    @Override
    protected void initDatas() {

    }
}
