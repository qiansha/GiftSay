package com.lanou3g.giltsay.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/9/8.
 */
public abstract class AbsBaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initViews();
        initDatas();
    }

    /**
     * 设置布局文件
     * @return R.layout.XX
     */
    protected abstract int setLayout();
    /**
     * 初始化组件
     */
    protected abstract void initViews();
    /**
     * 初始化数据
     */
    protected abstract void initDatas();
    /**
     *  简化findViewById
     */
    protected <T extends View> T byView(int resId){
        return (T) findViewById(resId);
    }
    /**
     * 跳转不传值
     */
    protected void goTo(Context from,Class<? extends AbsBaseActivity>to){
        startActivity(new Intent(from,to));
    }
    /**
     * 跳转传值
     */
    protected void goTo(Context from,Class<? extends AbsBaseActivity>to,Bundle extras) {
        Intent intent = new Intent(from, to);
        intent.putExtras(extras);
        startActivity(intent);
    }
    /**
     * 结束动画
     */
    public void finish(){
        super.finish();
    }
    }
