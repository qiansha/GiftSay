package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/10/8.
 */
public class RotateNoIdDetailTodayFragment extends AbsBaseFragment{
    public static RotateNoIdDetailTodayFragment newInstance() {
        Bundle args = new Bundle();
        RotateNoIdDetailTodayFragment fragment = new RotateNoIdDetailTodayFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_rotate_detail_noid_today;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
