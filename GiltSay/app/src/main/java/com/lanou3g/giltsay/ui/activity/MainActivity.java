package com.lanou3g.giltsay.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.ClassFragment;
import com.lanou3g.giltsay.ui.fragment.HomePageFragment;
import com.lanou3g.giltsay.ui.fragment.ListFragment;
import com.lanou3g.giltsay.ui.fragment.PersonFragment;

import android.support.design.widget.TabLayout;
import android.widget.RadioGroup;

public class MainActivity extends AbsBaseActivity {
    private HomePageFragment homePageFragment;
    private ListFragment listFragment;
    private ClassFragment classFragment;
    private PersonFragment personFragment;
    private RadioGroup radioGroup;



    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        radioGroup = byView(R.id.main_radio);
        homePageFragment = new HomePageFragment();
        listFragment = new ListFragment();
        classFragment = new ClassFragment();
        personFragment = new PersonFragment();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.homepage_rbtn:
                        transaction.replace(R.id.main_repace_view,homePageFragment);
                        break;
                    case R.id.list_rbtn:
                        transaction.replace(R.id.main_repace_view,listFragment);
                        break;
                    case R.id.class_rbtn:
                        transaction.replace(R.id.main_repace_view,classFragment);
                        break;
                    case R.id.person_rbtn:
                        transaction.replace(R.id.main_repace_view,personFragment);
                        break;

                }
                transaction.commit();
            }
        });
        radioGroup.check(R.id.homepage_rbtn);

    }

    @Override
    protected void initDatas() {

    }
}
