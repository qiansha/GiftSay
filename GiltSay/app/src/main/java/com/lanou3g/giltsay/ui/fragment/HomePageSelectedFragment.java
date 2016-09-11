package com.lanou3g.giltsay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleHorBean;
import com.lanou3g.giltsay.ui.adapter.HomePageSelectedHorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class HomePageSelectedFragment extends AbsBaseFragment{
    private ListView homeSelHorListView;
    private HomePageSelectedHorAdapter homePageSelectedHorAdapter;
    private List<HomeSeleHorBean>datas;
    @Override
    protected int setLayout() {
        return R.layout.fragment_homepage_selected;
    }

    @Override
    protected void initViews() {

        homeSelHorListView = byView(R.id.homepage_selected_horizontal_list);


    }

    @Override
    protected void initDatas() {


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        datas = new ArrayList<>();
        homePageSelectedHorAdapter = new HomePageSelectedHorAdapter(getActivity());
        homePageSelectedHorAdapter.setDatas(datas);
        homeSelHorListView.setAdapter(homePageSelectedHorAdapter);
        super.onActivityCreated(savedInstanceState);
        Log.d("HomePageSelectedFragmen", "....");
    }
}
