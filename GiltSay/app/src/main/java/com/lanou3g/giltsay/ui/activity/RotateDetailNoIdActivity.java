package com.lanou3g.giltsay.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.homepagefragment.RotateNoIdDetailAgoFragment;
import com.lanou3g.giltsay.ui.fragment.homepagefragment.RotateNoIdDetailTodayFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/8.
 * 没有Id轮播图详情页
 */
public class RotateDetailNoIdActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout noIdTl;
    private ViewPager noIdVp;
    private ImageView backImg;
    private List<Fragment>fragments;
    private MainPagerAdapter mainPagerAdapter;
    private String url;
    @Override
    protected int setLayout() {
        return R.layout.activity_rotate_no_id_detail;
    }

    @Override
    protected void initViews() {
          noIdTl = byView(R.id.rotate_detail_noid_tl);
        noIdVp = byView(R.id.rotate_detail_noid_vp);
        backImg = byView(R.id.rotate_detail_noid_back_img);
    }

    @Override
    protected void initDatas() {
        url = StaticClassHelper.rotateDetailUrlStartUrl + StaticClassHelper.rotateDetailUrlEndUrl;
        Log.d("uuu", url);
        //返回的点击事件
        backImg.setOnClickListener(this);
        fragments = new ArrayList<>();
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragments);
        fragments.add(RotateNoIdDetailTodayFragment.newInstance());
        fragments.add(RotateNoIdDetailAgoFragment.newInstance());
        noIdVp.setAdapter(mainPagerAdapter);

        noIdTl.setupWithViewPager(noIdVp);
        noIdTl.getTabAt(0).setText("今日礼物");
        noIdTl.getTabAt(1).setText("往期礼物");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rotate_detail_noid_back_img:
                finish();
                break;
        }
    }
}
