package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.HomeSeleLvAdapter;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 * 轮播图详情
 */
public class RotateDetailActivity extends AbsBaseActivity implements VolleyResult {
    private HomeSeleLvAdapter homeSeleLvAdapter;
    private List<HomeSeleBean> homeSeleBean;
    private ListView detailLv;
    @Override
    protected int setLayout() {
        return R.layout.activity_rotate_detail;
    }

    @Override
    protected void initViews() {

        detailLv = byView(R.id.rotate_detail_lv);

    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        if (id != 0) {
            String url = StaticClassHelper.rotateDetailIdStartUrl + id + StaticClassHelper.rotateDetailIdEndUrl;
            homeSeleLvAdapter = new HomeSeleLvAdapter(getBaseContext());
            VolleyInstance.getInstance().startRequest(url,this);
        }
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        HomeSeleBean homeSeleBean = gson.fromJson(resultStr,HomeSeleBean.class);
        List<HomeSeleBean.DataBean.ItemsBean> homeSeleBeanData = homeSeleBean.getData().getItems();

        detailLv.setAdapter(homeSeleLvAdapter);
        homeSeleLvAdapter.setDatas(homeSeleBeanData);

    }

    @Override
    public void failure() {

    }
}
