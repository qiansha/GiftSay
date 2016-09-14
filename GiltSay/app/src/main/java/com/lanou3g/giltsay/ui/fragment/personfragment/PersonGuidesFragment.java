package com.lanou3g.giltsay.ui.fragment.personfragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/11.
 * 个人页面攻略Fragment
 */
public class PersonGuidesFragment extends AbsBaseFragment {
    public static PersonGuidesFragment newInstance() {

        Bundle args = new Bundle();

        PersonGuidesFragment fragment = new PersonGuidesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment__person_guides;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
