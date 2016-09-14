package com.lanou3g.giltsay.ui.fragment.personfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 个人页面
 */
public class PersonFragment extends AbsBaseFragment {
    private static final int myColor = 0XFFFF0033;
    private RadioGroup personRg;
    private ViewPager personVp;
    private List<Fragment> datas;

    public static PersonFragment newInstance() {

        Bundle args = new Bundle();

        PersonFragment fragment = new PersonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        personRg = byView(R.id.person_rg);
        personVp = byView(R.id.person_vp);


    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        datas.add(PersonGuidesFragment.newInstance());
        datas.add(PersonSingleFragment.newInstance());
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), datas);
        personVp.setAdapter(mainPagerAdapter);
        personRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.person_guides_rb:
                        break;
                    case R.id.person_single_rb:
                        break;
                }
            }
        });


    }
}
