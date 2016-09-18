package com.lanou3g.giltsay.model.bean;

/**
 * Created by dllo on 16/9/17.
 */
public class HomeSeRotateBean {
    private int imgId;
    private String imgUrl;

    public HomeSeRotateBean(int imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }

//    public HomeSeRotateBean(int ic_launcher) {
//
//    }


    public HomeSeRotateBean(int imgId) {
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
