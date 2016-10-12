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
import com.lanou3g.giltsay.model.bean.ListDetaliHTMLBean;
import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.model.db.SQInstance;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.app.GiftApp;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailSingleFragment;
import com.lanou3g.giltsay.ui.fragment.listfragment.ListDetailDetailFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/9/28.
 * 榜单详情页   包括单品详情两个Fragment
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
    private ImageView shareImg;
    private String detailUrl;
    private String singleUrl;
    private LiteOrm liteOrm;
    private boolean isCollect = false;
    QueryBuilder<SQBean> qb = new QueryBuilder<>(SQBean.class);

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
        shareImg = byView(R.id.list_detail_share_img);

    }

    @Override
    protected void initDatas() {

        liteOrm = LiteOrm.newSingleInstance(GiftApp.getContext(), "gift.db");
        Intent intent = getIntent();
        itemId = intent.getIntExtra("id", 0);
        singleUrl = StaticClassHelper.listDetailStartUrl + itemId + StaticClassHelper.listDetailEndUrl;
        Log.d("ListDetailActivity", singleUrl);
        detailUrl = StaticClassHelper.listDetailStartUrl + itemId;
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ListDetailSingleFragment.newInstance(itemId + ""));
        fragments.add(ListDetailDetailFragment.newInstance(detailUrl));
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        listDetailVp.setAdapter(mainPagerAdapter);
        listDetailTl.setupWithViewPager(listDetailVp);
        listDetailTl.setSelectedTabIndicatorColor(Color.WHITE);
        listDetailTl.setSelectedTabIndicatorHeight(3);
        listDetailTl.setTabTextColors(Color.WHITE, Color.WHITE);
        listDetailTl.getTabAt(0).setText("单品");
        listDetailTl.getTabAt(1).setText("详情");
        VolleyInstance.getInstance().startRequest(detailUrl, this);
        beans = new SQBean(imgUrl, name, description, price, itemId);
        backImg.setOnClickListener(this);
        shareImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.list_detail_back_img:
                finish();
                break;
            case R.id.list_detail_share_img:
                share();
                break;
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
                    beans = new SQBean(imgUrl, name, description, price, itemId);
                    Log.d("ListDetailActivity", "bean:" + beans);
                    SQInstance.getInstance().insert(beans);
                    isCollect = true;

                } else {
                    loveImg.setImageResource(R.mipmap.icon_heart_unselected);
                    Toast.makeText(ListDetailActivity.this, "取消喜欢成功", Toast.LENGTH_SHORT).show();
                    SQInstance.getInstance().deleteByName(name);
                    isCollect = false;
                }
            }
        });
        if (SQInstance.getInstance().queryByName(name).size() != 0) {
            loveImg.setImageResource(R.mipmap.icon_heart_selected);
            isCollect = true;
        }
        Log.d("ListDetailActivity", "SQInstance.getInstance().queryByName(name).size():" + SQInstance.getInstance().queryByName(name).size());
    }

    @Override
    public void failure() {

    }

    private void share() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(name);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(description);
        oks.setImageUrl(imgUrl);
//        oks.setAddress(detailUrl);
//        oks.setVenueName("来自礼物说");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//        oks.setImageUrl(imgUrl);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(detailUrl);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(detailUrl);
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(detailUrl);
        // 启动分享GUI
        oks.show(this);

    }
}
