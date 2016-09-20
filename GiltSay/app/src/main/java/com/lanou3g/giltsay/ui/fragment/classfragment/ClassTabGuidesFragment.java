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
import com.lanou3g.giltsay.ui.adapter.ClassGuidesColumnRvAdapter;
import com.lanou3g.giltsay.ui.adapter.ClassGuidesMoreRvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.lanou3g.giltsay.view.FullyGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 分类中的攻略页面
 */
public class ClassTabGuidesFragment extends AbsBaseFragment implements VolleyResult {

    private RecyclerView classColumnRecyclerView;//栏目RecyclerView
    //    private RecyclerView classMoreRecyclerView;   //品类RecyclerView
    private RecyclerView classClassRecyclerView;//品类RecyclerView
    private RecyclerView classStyleRecyclerView;//风格RecyclerView
    private RecyclerView classObjectRecyclerView;   //对象RecyclerView
    private List<ClassGuidesColumnRvBean> datas;
    private ClassGuidesColumnRvAdapter classGuidesColumnRvAdapter;//栏目Adapter
    private ClassGuidesMoreRvAdapter classRvAdapter;//品类Adapter
    private ClassGuidesMoreRvAdapter styleRvAdapter;//风格Adapter
    private ClassGuidesMoreRvAdapter objectRvAdapter;//对象Adapter

    private String url;

    public static ClassTabGuidesFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
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
        classColumnRecyclerView = byView(R.id.class_column_rv);
//       classMoreRecyclerView = byView(R.id.class_class_rv);
        classClassRecyclerView = byView(R.id.class_class_rv);
        classStyleRecyclerView = byView(R.id.class_style_rv);
        classObjectRecyclerView = byView(R.id.class_object_rv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = new Bundle();
        this.url = bundle.getString("url");
        //栏目
        VolleyInstance.getInstance().startRequest(StaticClassHelper.classColumnUrl, this);
        //品类
        VolleyInstance.getInstance().startRequest(StaticClassHelper.classClassUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                //    品类
                ClassGuidesMoreRvBean classGuidesMoreRvBean = gson.fromJson(resultStr, ClassGuidesMoreRvBean.class);
                List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean> channelGroupsBeen = classGuidesMoreRvBean.getData().getChannel_groups();
                classRvAdapter = new ClassGuidesMoreRvAdapter(context);
                GridLayoutManager gmMore = new GridLayoutManager(context, 2);
                classClassRecyclerView.setLayoutManager(gmMore);
                classClassRecyclerView.setAdapter(classRvAdapter);

                styleRvAdapter = new ClassGuidesMoreRvAdapter(context);
                GridLayoutManager gmStyle = new GridLayoutManager(context, 2);
                classStyleRecyclerView.setLayoutManager(gmStyle);
                classStyleRecyclerView.setAdapter(styleRvAdapter);

                objectRvAdapter = new ClassGuidesMoreRvAdapter(context);
                GridLayoutManager gmObject = new GridLayoutManager(context, 2);
                classObjectRecyclerView.setLayoutManager(gmObject);
                classObjectRecyclerView.setAdapter(objectRvAdapter);

                //品类
                if (channelGroupsBeen.get(0).getName().equals("品类")) {
                    List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean.ChannelsBean> classBean = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        classBean.add(channelGroupsBeen.get(0).getChannels().get(i));
                        classRvAdapter.setDatas(classBean);
                    }
                }
                //风格
                if (channelGroupsBeen.get(1).getName().equals("风格")) {
                    List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean.ChannelsBean> styleBean = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        styleBean.add(channelGroupsBeen.get(1).getChannels().get(i));
                        styleRvAdapter.setDatas(styleBean);
                    }
                }
                //对象
                List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean.ChannelsBean> objectBean = new ArrayList<>();
                for (int i = 0; i < 6; i++) {
                    objectBean.add(channelGroupsBeen.get(2).getChannels().get(i));
                    objectRvAdapter.setDatas(objectBean);
                }
            }

            @Override
            public void failure() {

            }
        });
    }

    @Override
    public void success(String resultStr) {
        //栏目
        Gson gson = new Gson();
        ClassGuidesColumnRvBean classGuidesColumnRvBean = gson.fromJson(resultStr, ClassGuidesColumnRvBean.class);
        List<ClassGuidesColumnRvBean.DataBean.ColumnsBean> columnsBeen = classGuidesColumnRvBean.getData().getColumns();
        classGuidesColumnRvAdapter = new ClassGuidesColumnRvAdapter(context);
        GridLayoutManager gm = new GridLayoutManager(context, 3, LinearLayoutManager.HORIZONTAL, false);
        classColumnRecyclerView.setLayoutManager(gm);
        classColumnRecyclerView.setAdapter(classGuidesColumnRvAdapter);
        classGuidesColumnRvAdapter.setDatas(columnsBeen);
        Log.d("ClassTabGuidesFragment", "columnsBeen:" + columnsBeen);

    }

    @Override
    public void failure() {

    }
}
