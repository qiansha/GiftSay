package com.lanou3g.giltsay.model.bean;

import android.widget.ImageView;

/**
 * Created by dllo on 16/9/11.
 * 精选页面REcyclerView的实体类
 */
public class HomeSeleRvBean {
    private int img;

    public HomeSeleRvBean(int img) {
        this.img = img;
    }

    public HomeSeleRvBean() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
