package com.lanou3g.giltsay.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.classfragment.ClassFragment;
import com.lanou3g.giltsay.ui.fragment.homepagefragment.HomePageFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListFragment;
import com.lanou3g.giltsay.ui.fragment.personfragment.PersonFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import android.widget.RadioGroup;

/**
 * 主页面Activity
 */

public class MainActivity extends AbsBaseActivity {
    //    private HomePageFragment homePageFragment;
//    private ListFragment listFragment;
//    private ClassFragment classFragment;
//    private PersonFragment personFragment;
    private RadioGroup radioGroup;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        radioGroup = byView(R.id.main_radio);


    }

    @Override
    protected void initDatas() {
//        homePageFragment = new HomePageFragment();
//        listFragment = new ListFragment();
//        classFragment = new ClassFragment();
//        personFragment = new PersonFragment();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.homepage_rbtn:
                        transaction.replace(R.id.main_repace_view, HomePageFragment.newInstance(StaticClassHelper.homeSeleUrl));
                        break;
                    case R.id.list_rbtn:
                        transaction.replace(R.id.main_repace_view, ListFragment.newInstance());
                        break;
                    case R.id.class_rbtn:
                        transaction.replace(R.id.main_repace_view, ClassFragment.newInstance());
                        break;
                    case R.id.person_rbtn:
                        transaction.replace(R.id.main_repace_view, PersonFragment.newInstance());
                        break;

                }
                transaction.commit();
            }
        });
        radioGroup.check(R.id.homepage_rbtn);

    }
}
