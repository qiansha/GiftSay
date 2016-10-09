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
    //自增长主键
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    private int itemId;

    private int likeCount;

    public SQBean() {
    }

    public SQBean(int id, int itemId, int likeCount) {
        this.id = id;
        this.itemId = itemId;
        this.likeCount = likeCount;
    }

    public SQBean(int itemId, int likeCount) {
        this.itemId = itemId;
        this.likeCount = likeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
