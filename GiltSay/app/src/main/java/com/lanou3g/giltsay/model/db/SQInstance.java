package com.lanou3g.giltsay.model.db;

import android.database.sqlite.SQLiteDatabase;

import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.ui.app.GiftApp;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.List;

/**
 * Created by dllo on 16/10/8.
 * 数据库封装单例类
 */
public class SQInstance {
    private static SQInstance instance;
    /**
     * 数据库名字
     */
    private static final String DB_NAME = "collect.db";

    private LiteOrm liteOrm;

    private SQInstance() {
        liteOrm = LiteOrm.newSingleInstance(GiftApp.getContext(), DB_NAME);
    }

    public static SQInstance getInstance() {
        if (instance == null) {
            synchronized (SQInstance.class) {
                if (instance == null) {
                    instance = new SQInstance();
                }
            }
        }
        return instance;
    }
    /*******************增删改查*****************/

    /**
     * 插入集合数据
     */
    private void insert(List<SQBean> sqb) {
        liteOrm.insert(sqb);
    }

    /**
     * 插入一条数据
     */
    public void insert(SQBean sq) {
        liteOrm.insert(sq);
    }

    /**
     * 查询所有
     */
    public List<SQBean> queryAll() {
        return liteOrm.query(SQBean.class);
    }

    /**
     * 根据条件查询
     */
    public List<SQBean> queryByName(String name) {
        QueryBuilder<SQBean> qb = new QueryBuilder<>(SQBean.class);
        qb.where("name = ?", name);
        return liteOrm.query(qb);
    }

    /**
     * 根据标题查询数据库
     */
    public List<SQBean> queryByName(String name, int start, int end) {
        QueryBuilder<SQBean> qb = new QueryBuilder<>(SQBean.class);
        qb.where("name = ?", name);
        qb.limit(start, end);
        return liteOrm.query(qb);
    }

    /**
     * 根据Id查询
     */
    public List<SQBean> queryById(int id) {
        QueryBuilder<SQBean> qb = new QueryBuilder<>(SQBean.class);
        qb.where("id = ?", id);
        return liteOrm.query(qb);
    }

    /**
     * 按条件删除
     */
    public void deleteByName(String name) {
        WhereBuilder wb = new WhereBuilder(SQBean.class);
        wb.where("name = ?", name);
        liteOrm.delete(wb);
    }

    /**
     * 删除数据库所有数据
     */
    public void deleteAll() {
        liteOrm.deleteAll(SQBean.class);
    }


}
