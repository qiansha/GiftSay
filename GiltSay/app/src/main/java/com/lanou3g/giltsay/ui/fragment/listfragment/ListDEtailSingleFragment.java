package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListDeManyImgBean;
import com.lanou3g.giltsay.model.bean.ListDetailBean;
import com.lanou3g.giltsay.model.bean.ListDetaliHTMLBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.ListDetailSingleManyImgAdapter;
import com.lanou3g.giltsay.ui.adapter.ListDetailSingleRvAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/28.
 * 榜单详情——————单品
 */
public class ListDetailSingleFragment extends AbsBaseFragment implements VolleyResult {
    private boolean isRotate = false;
    private List<ListDeManyImgBean> imgBean;
    private ListDetailSingleManyImgAdapter imgAdapter;
    private LinearLayout pointLl;
    private int data;
    private int position;
    private int id;
    private String secondUrl;

    private String shortDescription;
    private String price;
    private String description;
    private RecyclerView singleRv;
    private ViewPager singleVp;
    private TextView singleShortDes;
    private TextView singlePrice;
    private TextView singleDescription;
    private ListDetailSingleRvAdapter listDetailSingleRvAdapter;
    private String url;
    private List<ListDetailBean.DataBean.RecommendItemsBean> datas;


    public static ListDetailSingleFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
        ListDetailSingleFragment fragment = new ListDetailSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_list_detail_tab_single;
    }

    @Override
    protected void initViews() {
        singleRv = byView(R.id.list_detail_single_rv);
        singleVp = byView(R.id.list_detali_single_vp);
        singleShortDes = byView(R.id.list_detail_single_short_description);
        singlePrice = byView(R.id.list_detail_single_price);
        singleDescription = byView(R.id.list_detail_single_description);
        pointLl = byView(R.id.list_detail_single_point_ll);


    }

    @Override
    protected void initDatas() {


        Bundle bundler = getArguments();
        this.url = bundler.getString("url");
        Log.d("sisisi", url);
        listDetailSingleRvAdapter = new ListDetailSingleRvAdapter(context);
        GridLayoutManager gm = new GridLayoutManager(context, 2);
        singleRv.setLayoutManager(gm);
        singleRv.setAdapter(listDetailSingleRvAdapter);


        String singleUrl = StaticClassHelper.listDetailStartUrl + url + StaticClassHelper.listDetailEndUrl;
        secondUrl = StaticClassHelper.listDetailStartUrl + url;
        VolleyInstance.getInstance().startRequest(singleUrl, this);


        Log.d("chengg", secondUrl);
        VolleyInstance.getInstance().startRequest(secondUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                imgBean = new ArrayList<>();

                Gson gson = new Gson();
                ListDetaliHTMLBean bean = gson.fromJson(resultStr, ListDetaliHTMLBean.class);
                for (int i = 0; i < bean.getData().getImage_urls().size(); i++) {
                    imgBean.add(new ListDeManyImgBean(bean.getData().getImage_urls().get(i)));
                    imgAdapter.setDatas(imgBean);
                }

                data = bean.getData().getImage_urls().size();
                singleShortDes.setText(bean.getData().getShort_description());
                singlePrice.setText(bean.getData().getPrice());
                singleDescription.setText(bean.getData().getDescription());
                addPoints();
                changePoints();
            }

            @Override
            public void failure() {
            }
        });
        /**
         * 顶部图片
         */
        /**
         * ViewPager适配器
         */
        imgAdapter = new ListDetailSingleManyImgAdapter(context);
        singleVp.setAdapter(imgAdapter);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListDetailBean listDetailBean = gson.fromJson(resultStr, ListDetailBean.class);
        datas = listDetailBean.getData().getRecommend_items();
        listDetailSingleRvAdapter.setDatas(datas);
        Log.d("11111", "datas:" + datas);
    }

    @Override
    public void failure() {

    }

    private void addPoints() {
        Log.d("data", "data:" + data);
        for (int i = 0; i < data; i++) {
            CircleImageView pointIv = new CircleImageView(context);
            pointIv.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            pointIv.setLayoutParams(params);

            if (i == 0) {
                pointIv.setImageResource(R.mipmap.abc_ab_bottom_solid_dark_holo9);
                Log.d("xiaodian", "xiaodian");
            } else {
                pointIv.setImageResource(R.mipmap.abc_ab_bottom_solid_light_holo9);
            }
            pointLl.addView(pointIv);

        }
    }

    private void changePoints() {
        singleVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < data; i++) {
                    ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                    pointIv.setImageResource(R.mipmap.abc_ab_bottom_solid_light_holo9);
                }
                ImageView iv = (ImageView) pointLl.getChildAt(position % data);
                iv.setImageResource(R.mipmap.abc_ab_bottom_solid_dark_holo9);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
