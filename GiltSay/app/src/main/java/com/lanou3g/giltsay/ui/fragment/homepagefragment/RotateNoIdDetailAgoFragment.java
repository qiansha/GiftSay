package com.lanou3g.giltsay.ui.fragment.homepagefragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/10/8.
 */
public class RotateNoIdDetailAgoFragment extends AbsBaseFragment{
    public static RotateNoIdDetailAgoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RotateNoIdDetailAgoFragment fragment = new RotateNoIdDetailAgoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_rotate_detail_noid_ago;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
