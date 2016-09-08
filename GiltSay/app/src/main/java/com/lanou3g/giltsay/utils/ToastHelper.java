package com.lanou3g.giltsay.utils;

import android.widget.Toast;

import com.lanou3g.giltsay.ui.app.GiftApp;

/**
 * Created by dllo on 16/9/8.
 * Toast的工具类
 */
public final class ToastHelper {
    //私有构造方法
    //锁死这个类
    private ToastHelper(){

    }
    private static boolean isDebug = true;
    public static void shortMsg(String msg){
        if (isDebug){
            Toast.makeText(GiftApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
    public static void longMsg(String msg){
        if (isDebug){
            Toast.makeText(GiftApp.getContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
