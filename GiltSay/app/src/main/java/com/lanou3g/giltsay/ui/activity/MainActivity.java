package com.lanou3g.giltsay.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.ClassFragment;
import com.lanou3g.giltsay.ui.fragment.HomePageFragment;
import com.lanou3g.giltsay.ui.fragment.ListFragment;
import com.lanou3g.giltsay.ui.fragment.PersonFragment;

import android.support.design.widget.TabLayout;

public class MainActivity extends AbsBaseActivity {
    private HomePageFragment homePageFragment;
    private ListFragment listFragment;
    private ClassFragment classFragment;
    private PersonFragment personFragment;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
