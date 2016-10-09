package com.lanou3g.giltsay.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/10/9.
 * 个人设置详情
 */
public class PersonSettingActivity extends AbsBaseActivity {
    private ImageView backImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_person_setting;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.person_setting_back_img);

    }

    @Override
    protected void initDatas() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
