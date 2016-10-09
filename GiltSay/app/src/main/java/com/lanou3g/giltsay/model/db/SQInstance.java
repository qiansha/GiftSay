package com.lanou3g.giltsay.model.db;

import android.database.sqlite.SQLiteDatabase;

import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.ui.app.GiftApp;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.List;

/**
 * Created by dllo on 16/10/8.
 * 数据库封装单例类
 */
public class SQInstance {
//    private static LiteOrm liteOrm;
//    private static SQInstance ourInstance = new SQInstance();
////    private LiteOrm liteOrm;
//    //数据库相关
////    private SQLiteDatabase database;
////    private SQHelper sqHelper;
//    /************实现单例****************/
//    /**
//     * 1.私有化构造方法
//     * 2.定义当前类静态对象
//     * 3.对外提供public的获取对象的方法
//     * 4.在步骤3中使用单例方法写单例
//     */
//    private SQInstance() {
//        //创建数据库
////        sqHelper = getSqHelper();
////        liteOrm = LiteOrm.newSingleInstance(GiftApp.getContext(),"giftsay.db");
////        liteOrm.setDebugged(true);
////        sqHelper = new SQHelper(SQApp.getContext(), DB_NAME, null, 1);
//        //生成数据库
////        database = getDatabase();
////        database = sqHelper.getWritableDatabase();
//        liteOrm = LiteOrm.newSingleInstance(GiftApp.getContext() , "giftsay.db" ) ;
//        liteOrm.setDebugged(true);
//    }
//
//    private static SQInstance instance;
//
//    public static SQInstance getInstance() {
//        //如果当前对象为null
//        if (instance == null) {
//            //内存中同步扫描该类
//            synchronized (SQInstance.class) {
//                if (instance == null) {
//                    //创建对象
//                    instance = new SQInstance();
//                }
//            }
//        }
//        return instance;
//    }
//
//
////    private SQInstance() {
////
////    }
//
////    public static SQInstancee getInstance() {
////        return ourInstance;
////    }
//
//    /**
//     * 插入一条记录
//     * @param t
//     */
//    public <T> long insert(T t) {
//        return liteOrm.save(t);
//    }
//
//    /**
//     * 插入所有记录
//     * @param list
//     */
//    public <T> void insertAll(List<T> list) {
//        liteOrm.save(list);
//    }
//
//    /**
//     * 查询所有
//     * @param cla
//     * @return
//     */
//    public <T> List<T> getQueryAll(Class<T> cla) {
//        return liteOrm.query(cla);
//    }
//
//    /**
//     * 查询  某字段 等于 Value的值
//     * @param cla
//     * @param field
//     * @param value
//     * @return
//     */
////    public <T> List<T> getQueryByWhere(Class<T> cla, String field, String[] value) {
////        return liteOrm.<T>query(new QueryBuilder(cla).where(field + "=?", value));
////    }
//
//    /**
//     * 查询  某字段 等于 Value的值  可以指定从1-20，就是分页
//     * @param cla
//     * @param field
//     * @param value
//     * @param start
//     * @param length
//     * @return
////     */
////    public <T> List<T> getQueryByWhereLength(Class<T> cla, String field, String[] value, int start, int length) {
////        return liteOrm.<T>query(new QueryBuilder(cla).where(field + "=?", value).limit(start, length));
////    }
//
//    /**
//     * 删除一个数据
//     * @param t
//     * @param <T>
//     */
//    public <T> void delete( T t){
//        liteOrm.delete( t ) ;
//    }
//
//    /**
//     * 删除一个表
//     * @param cla
//     * @param <T>
//     */
//    public <T> void delete( Class<T> cla ){
//        liteOrm.delete( cla ) ;
//    }
//
//    /**
//     * 删除集合中的数据
//     * @param list
//     * @param <T>
//     */
//    public <T> void deleteList( List<T> list ){
//        liteOrm.delete( list ) ;
//    }
//
//    /**
//     * 删除数据库
//     */
//    public void deleteDatabase(){
//        liteOrm.deleteDatabase() ;
//    }
}
