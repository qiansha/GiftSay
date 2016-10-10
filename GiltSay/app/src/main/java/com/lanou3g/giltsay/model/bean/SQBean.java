package com.lanou3g.giltsay.model.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/10/8.
 * 数据库实体类
 */
//表名:利用注解实现
@Table("likeCount")
public class SQBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    private String imgUrl;
    private String name;
    private String description;
    private String price;
    private int itemId;

    public SQBean() {
    }

    public SQBean(int id, String imgUrl, String name, String description, String price,int itemId) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemId = itemId;
    }

    public SQBean(String imgUrl, String name, String description, String price,int itemId) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
