package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailSingleFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailDetailFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailTalkFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class ListDetailActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView backImg;
    private TabLayout listDetailTl;
    private ViewPager listDetailVp;
    private int itemId;
    private String detailUrl;
    private String singleUrl;
//    private DetailReceiver detailReceiver;

    @Override
    protected int setLayout() {
        return R.layout.activity_list_detail;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.list_detail_back_img);
        listDetailTl = byView(R.id.list_detail_tl);
        listDetailVp = byView(R.id.list_detail_vp);


    }

    @Override
    protected void initDatas() {
//        /**
//         * 注册广播
//         */
//        detailReceiver = new DetailReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(StaticClassHelper.THE_ACTION);
//        registerReceiver(detailReceiver,intentFilter);

        Intent intent = getIntent();
        itemId = intent.getIntExtra("id",0);
        singleUrl = StaticClassHelper.listDetailStartUrl + itemId + StaticClassHelper.listDetailEndUrl;
        Log.d("ListDetailActivity", singleUrl);
        detailUrl = StaticClassHelper.listDetailStartUrl + itemId;
        List<Fragment>fragments = new ArrayList<>();
        fragments.add(ListDetailSingleFragment.newInstance(itemId + ""));
        fragments.add(ListDetailDetailFragment.newInstance(detailUrl));
        fragments.add(ListDetailTalkFragment.newInstance());
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragments);
        listDetailVp.setAdapter(mainPagerAdapter);
        listDetailTl.setupWithViewPager(listDetailVp);
        listDetailTl.setSelectedTabIndicatorColor(Color.WHITE);
        listDetailTl.setSelectedTabIndicatorHeight(3);
        listDetailTl.setTabTextColors(Color.WHITE,Color.WHITE);
        listDetailTl.getTabAt(0).setText("单品");
        listDetailTl.getTabAt(1).setText("详情");
        listDetailTl.getTabAt(2).setText("评论");
        backImg.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_detail_back_img:
                finish();
                break;
        }
    }
//    class DetailReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            /**
//             * 获得广播的传值
//             */
//            Log.d("bebebe", "广播");
//            String s1 = intent.getStringExtra("shortDescription");
//            Log.d("bebebe", s1);
////            price = intent.getStringExtra("price");
////            Log.d("brbrbr", price);
////            description = intent.getStringExtra("description");
////            Log.d("brbrbr", description);
////            singleShortDes.setText(shortDescription);
////            singlePrice.setText(price);
////            singleDescription.setText(description);
//
//
//
//
//        }
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(detailReceiver);
//    }
}
