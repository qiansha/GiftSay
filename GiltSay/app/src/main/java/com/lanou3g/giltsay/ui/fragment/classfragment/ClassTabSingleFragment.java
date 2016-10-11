package com.lanou3g.giltsay.ui.fragment.classfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassSingleBean;
import com.lanou3g.giltsay.model.net.VolleyInstance;
import com.lanou3g.giltsay.model.net.VolleyResult;
import com.lanou3g.giltsay.ui.adapter.ClassSingleLeftLvAdapter;
import com.lanou3g.giltsay.ui.adapter.ClassSingleRightListViewAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 分类中的单品页面
 */
public class ClassTabSingleFragment extends AbsBaseFragment implements VolleyResult {

    public static ClassTabSingleFragment newInstance() {
        Bundle args = new Bundle();
        ClassTabSingleFragment fragment = new ClassTabSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ClassSingleLeftLvAdapter classSingleLeftLvAdapter;
    private ListView singleLeftLv;
    private List<ClassSingleBean.DataBean.CategoriesBean> datas;
    private ListView singleRightLv;
    private ClassSingleRightListViewAdapter classSingleRightListViewAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_class_single;
    }

    @Override
    protected void initViews() {
        singleLeftLv = byView(R.id.class_single_lv);
        singleRightLv = byView(R.id.class_single_rightlv);
    }

    @Override
    protected void initDatas() {
        classSingleLeftLvAdapter = new ClassSingleLeftLvAdapter(context);
        singleLeftLv.setAdapter(classSingleLeftLvAdapter);
        singleLeftLv.setVerticalScrollBarEnabled(true);
        singleLeftLv.setSelected(true);
        datas = new ArrayList<>();

        classSingleRightListViewAdapter = new ClassSingleRightListViewAdapter(context);
        singleRightLv.setAdapter(classSingleRightListViewAdapter);
        VolleyInstance.getInstance().startRequest(StaticClassHelper.classSingleUrl, this);

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        /**
         * 左边ListView
         */
        ClassSingleBean classSingleBean = gson.fromJson(resultStr, ClassSingleBean.class);
        List<ClassSingleBean.DataBean.CategoriesBean> categoriesBeen = classSingleBean.getData().getCategories();
        classSingleLeftLvAdapter.setDatas(categoriesBeen);
        /**
         *右边ListView
         */
        datas = new ArrayList<>();
        List<ClassSingleBean.DataBean.CategoriesBean> titleBean = classSingleBean.getData().getCategories();
        List<ClassSingleBean.DataBean.CategoriesBean> dataBean = classSingleBean.getData().getCategories();
        for (int i = 0; i < dataBean.size(); i++) {
            datas.add(dataBean.get(i));
            Log.d("ClassTabSingleFragment", "data:" + datas + null);
        }
        classSingleRightListViewAdapter.setDatas(datas);
        singleRightLv.setAdapter(classSingleRightListViewAdapter);
        addScroll();


    }

    private void addScroll() {
        singleLeftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                classSingleLeftLvAdapter.setSelectIndex(position);
                classSingleLeftLvAdapter.notifyDataSetChanged();
                singleLeftLv.smoothScrollToPositionFromTop(position, 0);
                singleRightLv.smoothScrollToPositionFromTop(position, 0);
            }
        });

        singleRightLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                this.scrollState = scrollState;

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING){
                    return;
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    return;
                }
                /**
                 * 当手指拖着ListView滑动的时候
                 */
//                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    singleLeftLv.smoothScrollToPositionFromTop(firstVisibleItem + 1, 0);
                    classSingleLeftLvAdapter.setSelectIndex(firstVisibleItem + 1);
                    classSingleLeftLvAdapter.notifyDataSetChanged();
                    Log.d("vvv", "firstVisibleItem:" + firstVisibleItem);
//                }



            }
        });
    }


    @Override
    public void failure() {

    }
}
