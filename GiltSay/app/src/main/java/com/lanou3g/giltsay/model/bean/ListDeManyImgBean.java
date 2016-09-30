package com.lanou3g.giltsay.model.bean;

/**
 * Created by dllo on 16/9/29.
 */
public class ListDeManyImgBean {
    private int imgId;
    private String imgUrl;

    public ListDeManyImgBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ListDeManyImgBean(int imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;

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
