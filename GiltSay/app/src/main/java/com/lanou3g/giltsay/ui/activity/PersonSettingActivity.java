package com.lanou3g.giltsay.ui.activity;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.utils.DataClearHelper;

import java.io.File;

/**
 * Created by dllo on 16/10/9.
 * 个人设置详情
 */
public class PersonSettingActivity extends AbsBaseActivity {
    private RelativeLayout clearDataRl;
    private TextView dataTv;
    private ImageView backImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_person_setting;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.person_setting_back_img);
        clearDataRl = byView(R.id.person_setting_clear_data_rl);
        dataTv = byView(R.id.person_setting_clear_data_tv);

    }

    @Override
    protected void initDatas() {
        /**
         * 设置缓存大小
         */
        try {
            long b = DataClearHelper.getFolderSize(getBaseContext().getCacheDir());
            dataTv.setText(DataClearHelper.getFormatSize(b));
        } catch (Exception e) {
            e.printStackTrace();
        }


        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * 清除缓存
         */
        clearDataRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PersonSettingActivity.this, "清除缓存成功", Toast.LENGTH_SHORT).show();
                DataClearHelper.cleanInternalCache(getBaseContext());
                DataClearHelper.deleteFolderFile(getBaseContext().getCacheDir().getPath(), false);
                try {
                    long b = DataClearHelper.getFolderSize(getBaseContext().getCacheDir());
                    dataTv.setText(DataClearHelper.getFormatSize(b));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
