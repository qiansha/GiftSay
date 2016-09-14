package com.lanou3g.giltsay.ui.fragment.personfragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/11.
 * 个人页面单品Fragment
 */
public class PersonSingleFragment extends AbsBaseFragment {
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
