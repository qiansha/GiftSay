package com.lanou3g.giltsay.ui.fragment.personfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.activity.PersonSettingActivity;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 个人页面
 */
public class PersonFragment extends AbsBaseFragment {
    private ImageView settingImg;
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
        settingImg = byView(R.id.person_setting_img);
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
        settingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonSettingActivity.class);
                startActivity(intent);
            }
        });


    }
}
