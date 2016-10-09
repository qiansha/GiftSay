package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassGuidesColumnDetailBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.ClassGuidesColumnDetailLvAdapter;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.List;

/**
 * Created by dllo on 16/10/8.
 * 分类栏目详情
 */
public class ClassColumnDetailActivity extends AbsBaseActivity implements VolleyResult, View.OnClickListener {
    private ImageView backImg, shareImg;
    private TextView titleTv;
    private int id;
    private String url;
    private ListView columnDetailLv;
    private ClassGuidesColumnDetailLvAdapter lvAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_class_column_detail;
    }

    @Override
    protected void initViews() {
        columnDetailLv = byView(R.id.class_column_detail_lv);
        titleTv = byView(R.id.class_column_detail_title_tv);
        backImg = byView(R.id.class_column_detail_back_img);
        shareImg = byView(R.id.class_column_detail_share_img);

    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        url = StaticClassHelper.classColumnDetailStartUrl + id + StaticClassHelper.classColumnDetailEndUrl;
        Log.d("ClassColumnDetailActivi", url);
        VolleyInstance.getInstance().startRequest(url, this);
        //点击
        backImg.setOnClickListener(this);
        shareImg.setOnClickListener(this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ClassGuidesColumnDetailBean bean = gson.fromJson(resultStr, ClassGuidesColumnDetailBean.class);
        List<ClassGuidesColumnDetailBean.DataBean.PostsBean> datas = bean.getData().getPosts();
        lvAdapter = new ClassGuidesColumnDetailLvAdapter(getBaseContext());
        lvAdapter.setDatas(datas);
        columnDetailLv.setAdapter(lvAdapter);
        String title = bean.getData().getTitle();
        titleTv.setText(title);
    }

    @Override
    public void failure() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class_column_detail_back_img:
                finish();
                break;
            case R.id.class_column_detail_share_img:


                break;
        }
    }
}
