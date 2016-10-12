package com.lanou3g.giltsay.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.fragment.classfragment.ClassFragment;
import com.lanou3g.giltsay.ui.fragment.homepagefragment.HomePageFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListFragment;
import com.lanou3g.giltsay.ui.fragment.personfragment.PersonFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * 主页面Activity
 */

public class MainActivity extends AbsBaseActivity {
    private RadioGroup radioGroup;
    // 定义一个变量，来标识是否退出
    private  boolean isExit = false;

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
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.homepage_rbtn:
                        transaction.replace(R.id.main_repace_view, HomePageFragment.newInstance(""));
                        break;
                    case R.id.list_rbtn:
                        transaction.replace(R.id.main_repace_view, ListFragment.newInstance(""));
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



    private  Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次后退键退出程序", Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            this.finish();
        }
    }
}
