package com.lanou3g.giltsay.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.model.db.SQInstance;
import com.lanou3g.giltsay.ui.adapter.PersonSingleDetailAdapter;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;

import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 个人单品详情
 */
public class PersonSingleDetailActivity extends AbsBaseActivity{
    private RecyclerView recyclerView;
    private PersonSingleDetailAdapter rvAdapter;
    @Override
    protected int setLayout() {
        return R.layout.activity_person_single_detail;
    }

    @Override
    protected void initViews() {
        recyclerView = byView(R.id.person_single_detail_rv);

    }

    @Override
    protected void initDatas() {
        rvAdapter = new PersonSingleDetailAdapter(this);
        recyclerView.setAdapter(rvAdapter);
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(glm);
        final List<SQBean> bean =  SQInstance.getInstance().queryAll();
        rvAdapter.setDatas(bean);
        rvAdapter.setRecyclerViewItemClick(new RecyclerViewItemClick() {
            @Override
            public void onRvItemClickListener(int position, String str) {
                int id = bean.get(position).getItemId();
                Intent intent = new Intent(PersonSingleDetailActivity.this,ListDetailActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}
