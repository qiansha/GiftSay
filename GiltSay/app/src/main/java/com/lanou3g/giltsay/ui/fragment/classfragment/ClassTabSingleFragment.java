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
    private List<ClassSingleBean.DataBean.CategoriesBean>datas;
    private TextView singleTopTv;
//    private ClassSingleRightRvAdapter classSingleRightRvAdapter;
//    private RecyclerView rightRv;
    private ListView singleRightLv;
    private ClassSingleRightListViewAdapter classSingleRightListViewAdapter;
    private int selectIndex = 0;


    @Override
    protected int setLayout() {
        return R.layout.fragment_class_single;
    }

    @Override
    protected void initViews() {
        singleLeftLv = byView(R.id.class_single_lv);
//        rightRv = byView(R.id.class_single_rv);
        singleRightLv = byView(R.id.class_single_rightlv);
        singleTopTv = byView(R.id.calss_single_tv);

    }

    @Override
    protected void initDatas() {
        classSingleLeftLvAdapter = new ClassSingleLeftLvAdapter(context);
        singleLeftLv.setAdapter(classSingleLeftLvAdapter);
        datas = new ArrayList<>();

        classSingleRightListViewAdapter = new ClassSingleRightListViewAdapter(context);
        singleRightLv.setAdapter(classSingleRightListViewAdapter);

//        classSingleRightRvAdapter.setDatas(bean.get(position).getSubcategories());

//        classSingleRightRvAdapter = new ClassSingleRightRvAdapter(context);
//        GridLayoutManager gm = new GridLayoutManager(context,3, LinearLayoutManager.VERTICAL,false
//        );
//        rightRv.setLayoutManager(gm);
//        rightRv.setAdapter(classSingleRightRvAdapter);



        VolleyInstance.getInstance().startRequest(StaticClassHelper.classSingleUrl,this);

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        /**
         * 左边ListView
         */
        ClassSingleBean classSingleBean = gson.fromJson(resultStr,ClassSingleBean.class);
        List<ClassSingleBean.DataBean.CategoriesBean>categoriesBeen = classSingleBean.getData().getCategories();
        classSingleLeftLvAdapter.setDatas(categoriesBeen);
        /**
         *右边ListView
         */


         datas = new ArrayList<>();
        List<ClassSingleBean.DataBean.CategoriesBean>titleBean = classSingleBean.getData().getCategories();
        List<ClassSingleBean.DataBean.CategoriesBean>dataBean = classSingleBean.getData().getCategories();
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
//                selectIndex = position;
//                List<ClassSingleBean.DataBean> categoriesBean = (List<ClassSingleBean.DataBean>) datas.get(position).getCategories().get(position);

                classSingleLeftLvAdapter.setSelectIndex(position);



                classSingleLeftLvAdapter.notifyDataSetChanged();
                singleLeftLv.smoothScrollToPositionFromTop(position,0);
//                classSingleRightListViewAdapter.setSelectIndex(position);
//                singleRightLv.smoothScrollByOffset(position);
//                singleRightLv.smoothScrollToPositionFromTop(position,0);
                classSingleRightListViewAdapter.setSelectIndex(position);
                singleRightLv.smoothScrollToPositionFromTop(position,0);


//                datas.add(dataBean.get(selectIndex));
//                Log.d("ClassTabSingleFragment", "data:" + datas + null);
//                //  }
//
//                classSingleRightListViewAdapter.setDatas(datas);

//                int rightPosition = singleLeftLv.getSelectedItemPosition();
//                singleRightLv.setSelection(rightPosition);
//                singleLeftLv.smoothScrollToPositionFromTop(position, 0);

//                singleRightLv.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, items));


            }
        });

        singleRightLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            private  int scrollState;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                    this.scrollState = scrollState;

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Toast.makeText(context, "firstVisibleItem:" + firstVisibleItem, Toast.LENGTH_SHORT).show();
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    return;
                }

//                selectIndex = firstVisibleItem;
//                classSingleRightListViewAdapter.setSelectIndex(firstVisibleItem);
//                classSingleRightListViewAdapter.notifyDataSetChanged();
//                singleRightLv.smoothScrollToPositionFromTop(firstVisibleItem,0);
//                classSingleLeftLvAdapter.setSelectIndex(firstVisibleItem);
//                singleLeftLv.setAdapter(classSingleLeftLvAdapter);
            }
        });
    }

    private void updateLeftListView(int rightPosition, int position) {
//        List<ClassSingleBean.DataBean.CategoriesBean>showTitle = new ArrayList<>();
//        if (showTitle.get(position))
    }

    @Override
    public void failure() {

    }
}
