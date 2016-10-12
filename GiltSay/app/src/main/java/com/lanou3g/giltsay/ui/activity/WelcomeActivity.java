package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.os.CountDownTimer;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/10/12.
 * 欢迎页
 */
public class WelcomeActivity extends AbsBaseActivity{
    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}
