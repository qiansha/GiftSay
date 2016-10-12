package com.lanou3g.giltsay.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;

/**
 * 搜索详情页
 */

public class SearchDetailActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView missTv;


    @Override
    protected int setLayout() {
        return R.layout.activity_search_detail;
    }

    @Override
    protected void initViews() {
        missTv = byView(R.id.search_detail_dismiss_tv);

    }

    @Override
    protected void initDatas() {
        missTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_detail_dismiss_tv:
                finish();
                break;
        }
    }
}
