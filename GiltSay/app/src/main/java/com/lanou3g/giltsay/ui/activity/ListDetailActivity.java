package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListDetailBean;
import com.lanou3g.giltsay.model.bean.ListDetaliHTMLBean;
import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.model.db.SQInstance;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.app.GiftApp;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailSingleFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailDetailFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailTalkFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class ListDetailActivity extends AbsBaseActivity implements View.OnClickListener, VolleyResult {
    private ImageView backImg;
    private TabLayout listDetailTl;
    private ViewPager listDetailVp;
    private ImageView loveImg;
    /**
     * 数据库需要的
     */
    private int itemId;
    private String imgUrl;
    private String name;
    private String price;
    private String description;
    private SQBean beans;

    private String detailUrl;
    private String singleUrl;
    private LiteOrm liteOrm;
    private boolean isCollect = false;
    QueryBuilder<SQBean>qb = new QueryBuilder<>(SQBean.class);

    @Override
    protected int setLayout() {
        return R.layout.activity_list_detail;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.list_detail_back_img);
        listDetailTl = byView(R.id.list_detail_tl);
        listDetailVp = byView(R.id.list_detail_vp);
        loveImg = byView(R.id.list_detail_love_img);


    }

    @Override
    protected void initDatas() {

        liteOrm = LiteOrm.newSingleInstance(GiftApp.getContext(),"gift.db");
//        SQBean sq = new SQBean(11111,1);
//        liteOrm.insert(sq);
//        Toast.makeText(this, "........", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        itemId = intent.getIntExtra("id",0);
        singleUrl = StaticClassHelper.listDetailStartUrl + itemId + StaticClassHelper.listDetailEndUrl;
        Log.d("ListDetailActivity", singleUrl);
        detailUrl = StaticClassHelper.listDetailStartUrl + itemId;
        List<Fragment>fragments = new ArrayList<>();
        fragments.add(ListDetailSingleFragment.newInstance(itemId + ""));
        fragments.add(ListDetailDetailFragment.newInstance(detailUrl));
//        fragments.add(ListDetailTalkFragment.newInstance());
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragments);
        listDetailVp.setAdapter(mainPagerAdapter);
        listDetailTl.setupWithViewPager(listDetailVp);
        listDetailTl.setSelectedTabIndicatorColor(Color.WHITE);
        listDetailTl.setSelectedTabIndicatorHeight(3);
        listDetailTl.setTabTextColors(Color.WHITE,Color.WHITE);
        listDetailTl.getTabAt(0).setText("单品");
        listDetailTl.getTabAt(1).setText("详情");
//        listDetailTl.getTabAt(2).setText("评论");
        VolleyInstance.getInstance().startRequest(detailUrl,this);
         beans = new SQBean(imgUrl,name,description,price,itemId);
        backImg.setOnClickListener(this);

     //收藏
//        loveImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isCollect == false) {
//                    loveImg.setImageResource(R.mipmap.icon_heart_selected);
//                    Toast.makeText(ListDetailActivity.this, "喜欢成功", Toast.LENGTH_SHORT).show();
//                    bean = new SQBean(imgUrl,name,description,price,itemId);
//                    Log.d("ListDetailActivity", "bean:" + bean);
//                    SQInstance.getInstance().insert(bean);
//                    isCollect = true;
//
//                }else {
//                    loveImg.setImageResource(R.mipmap.icon_heart_unselected);
//                    Toast.makeText(ListDetailActivity.this, "取消喜欢成功", Toast.LENGTH_SHORT).show();
//                    SQInstance.getInstance().deleteByName(name);
//                    isCollect = false;
//                }
//            }
//        });
//        if (SQInstance.getInstance().queryByName(name).size() != 0){
//            loveImg.setImageResource(R.mipmap.icon_heart_selected);
//            isCollect = true;
//        }
//        Log.d("ListDetailActivity", "SQInstance.getInstance().queryByName(name).size():" + SQInstance.getInstance().queryByName(name).size());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_detail_back_img:
                finish();
                break;
//            case R.id.list_detail_love_img:
//                if (isCollect == false) {
//                    loveImg.setImageResource(R.mipmap.icon_heart_selected);
//                    Toast.makeText(this, "喜欢成功", Toast.LENGTH_SHORT).show();
//                    bean = new SQBean(imgUrl,name,description,price,itemId);
//
//                    SQInstance.getInstance().insert(bean);
//                    isCollect = true;
//
//                }else {
//                    loveImg.setImageResource(R.mipmap.icon_heart_unselected);
//                    Toast.makeText(this, "取消喜欢成功", Toast.LENGTH_SHORT).show();
//                    SQInstance.getInstance().deleteByName(name);
//                    isCollect = false;
//                }
//                break;
        }
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListDetaliHTMLBean bean = gson.fromJson(resultStr, ListDetaliHTMLBean.class);
        name = bean.getData().getName();
        imgUrl = bean.getData().getCover_image_url();
        description = bean.getData().getShort_description();
        price = bean.getData().getPrice();
        loveImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollect == false) {
                    loveImg.setImageResource(R.mipmap.icon_heart_selected);
                    Toast.makeText(ListDetailActivity.this, "喜欢成功", Toast.LENGTH_SHORT).show();
                    beans = new SQBean(imgUrl,name,description,price,itemId);
                    Log.d("ListDetailActivity", "bean:" + beans);
                    SQInstance.getInstance().insert(beans);
                    isCollect = true;

                }else {
                    loveImg.setImageResource(R.mipmap.icon_heart_unselected);
                    Toast.makeText(ListDetailActivity.this, "取消喜欢成功", Toast.LENGTH_SHORT).show();
                    SQInstance.getInstance().deleteByName(name);
                    isCollect = false;
                }
            }
        });
        if (SQInstance.getInstance().queryByName(name).size() != 0){
            loveImg.setImageResource(R.mipmap.icon_heart_selected);
            isCollect = true;
        }
        Log.d("ListDetailActivity", "SQInstance.getInstance().queryByName(name).size():" + SQInstance.getInstance().queryByName(name).size());

    }

    @Override
    public void failure() {

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
