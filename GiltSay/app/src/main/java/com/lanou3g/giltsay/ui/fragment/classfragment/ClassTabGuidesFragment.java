package com.lanou3g.giltsay.ui.fragment.classfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassGuidesColumnRvBean;
import com.lanou3g.giltsay.model.bean.ClassGuidesMoreRvBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
//import com.lanou3g.giltsay.ui.adapter.ClassGuidesColumnRvAdapter;
import com.lanou3g.giltsay.ui.adapter.ClassGuidesMoreRvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.lanou3g.giltsay.view.FullyGridLayoutManager;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 分类中的攻略页面
 */
public class ClassTabGuidesFragment extends AbsBaseFragment implements VolleyResult {

    private RecyclerView classColumnRecyclerView;//栏目RecyclerView
    private RecyclerView classMoreRecyclerView;   //品类RecyclerView

    private List<ClassGuidesColumnRvBean>datas;
//    private ClassGuidesColumnRvAdapter classGuidesColumnRvAdapter;//栏目Adapter
    private ClassGuidesMoreRvAdapter classGuidesMoreRvAdapter;//品类,风格,对象Adapter

    private String url;

    public static ClassTabGuidesFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);
        ClassTabGuidesFragment fragment = new ClassTabGuidesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_class_guides;
    }

    @Override
    protected void initViews() {
//        classColumnRecyclerView = byView(R.id.class_column_rv);
       classMoreRecyclerView = byView(R.id.class_more_rv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = new Bundle();
        this.url = bundle.getString("url");
        //栏目
        VolleyInstance.getInstance().startRequest(StaticClassHelper.classColumnUrl,this);
        //品类
        VolleyInstance.getInstance().startRequest(StaticClassHelper.classClassUrl,this);
        //风格
        //对象
    }

    @Override
    public void success(String resultStr) {

        Gson gson = new Gson();
        //栏目
        ClassGuidesColumnRvBean classGuidesColumnRvBean = gson.fromJson(resultStr,ClassGuidesColumnRvBean.class);
        List<ClassGuidesColumnRvBean.DataBean.ColumnsBean>columnsBeen = classGuidesColumnRvBean.getData().getColumns();
//        classGuidesColumnRvAdapter = new ClassGuidesColumnRvAdapter(context);
        GridLayoutManager gm = new GridLayoutManager(context,3, LinearLayoutManager.HORIZONTAL,false);
//        classColumnRecyclerView.setLayoutManager(gm);
//        classColumnRecyclerView.setAdapter(classGuidesColumnRvAdapter);
       // classGuidesColumnRvAdapter.setDatas(columnsBeen);
        Log.d("ClassTabGuidesFragment", "columnsBeen:" + columnsBeen);
        //品类
        ClassGuidesMoreRvBean classGuidesMoreRvBean = gson.fromJson(resultStr,ClassGuidesMoreRvBean.class);
        List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean>channelGroupsBeen = classGuidesMoreRvBean.getData().getChannel_groups();
        classGuidesMoreRvAdapter = new ClassGuidesMoreRvAdapter(context);
//        GridLayoutManager gmMore = new GridLayoutManager(context,2);
//        classClassRecyclerView.setLayoutManager(gmMore);
//        //classStyleRecyclerView.setLayoutManager(gmMore);
//      //  classObjectRecyclerView.setLayoutManager(gmMore);
//        classClassRecyclerView.setAdapter(classGuidesMoreRvAdapter);
//        classGuidesMoreRvAdapter.setDatas(channelGroupsBeen);
        LinearLayoutManager gnMore = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        classMoreRecyclerView.setLayoutManager(gnMore);
        classMoreRecyclerView.setAdapter(classGuidesMoreRvAdapter);
        classGuidesMoreRvAdapter.setDatas(channelGroupsBeen);

        //风格
        //对象

    }

    @Override
    public void failure() {

    }
}
