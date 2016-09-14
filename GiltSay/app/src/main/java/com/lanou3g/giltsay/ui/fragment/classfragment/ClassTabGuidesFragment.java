package com.lanou3g.giltsay.ui.fragment.classfragment;

import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/9.
 * 分类中的攻略页面
 */
public class ClassTabGuidesFragment extends AbsBaseFragment {

    public static ClassTabGuidesFragment newInstance() {

        Bundle args = new Bundle();

        ClassTabGuidesFragment fragment = new ClassTabGuidesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_class_guides;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
