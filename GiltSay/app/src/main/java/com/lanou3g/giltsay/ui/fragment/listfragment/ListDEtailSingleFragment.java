package com.lanou3g.giltsay.ui.fragment.listfragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

/**
 * Created by dllo on 16/9/28.
 * 榜单详情——————单品
 */
public class ListDetailSingleFragment extends AbsBaseFragment implements VolleyResult {
    private List<ListDeManyImgBean> imgBean;
    private ListDetailSingleManyImgAdapter imgAdapter;
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


    }

    @Override
    protected void initDatas() {
        Bundle bundler = getArguments();
        this.url = bundler.getString("url");
        Log.d("sisisi", url);
        listDetailSingleRvAdapter = new ListDetailSingleRvAdapter(context);
        GridLayoutManager gm = new GridLayoutManager(context, 2);
        singleRv.setLayoutManager(gm);

        /**
         * 顶部图片
         */

        imgAdapter = new ListDetailSingleManyImgAdapter(context, imgBean);
        singleVp.setAdapter(imgAdapter);
//        singleVp.setCurrentItem(imgBean.size() * 100);

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
                    Log.d("size", "bean.getData().getImage_urls().size():" + bean.getData().getImage_urls().size());
                    imgBean.add(new ListDeManyImgBean(bean.getData().getImage_urls().get(i)));
                    imgAdapter.setDatas(imgBean);
                }
                singleVp.setAdapter(imgAdapter);
                singleShortDes.setText(bean.getData().getShort_description());
                singlePrice.setText(bean.getData().getPrice());
                singleDescription.setText(bean.getData().getDescription());

            }

            @Override
            public void failure() {
            }
        });

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ListDetailBean listDetailBean = gson.fromJson(resultStr, ListDetailBean.class);
        datas = listDetailBean.getData().getRecommend_items();
        listDetailSingleRvAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
