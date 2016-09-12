package com.lanou3g.giltsay.ui.fragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/9/11.
 */
public class PersonSingleFragment extends AbsBaseFragment{
    public static PersonSingleFragment newInstance() {
        
        Bundle args = new Bundle();
        
        PersonSingleFragment fragment = new PersonSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_person_single;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
