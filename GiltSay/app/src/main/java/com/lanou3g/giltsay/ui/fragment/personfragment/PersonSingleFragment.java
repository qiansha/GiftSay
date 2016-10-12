package com.lanou3g.giltsay.ui.fragment.personfragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.model.db.SQInstance;
import com.lanou3g.giltsay.ui.activity.PersonSingleDetailActivity;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/11.
 * 个人页面单品Fragment
 */
public class PersonSingleFragment extends AbsBaseFragment {
    private ImageView coverImg;
    private TextView countTv;

    public static PersonSingleFragment newInstance() {

        Bundle args = new Bundle();

        PersonSingleFragment fragment = new PersonSingleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_person_single;
    }

    @Override
    protected void initViews() {
        countTv = byView(R.id.person_collect_count_tv);
        coverImg = byView(R.id.person_collect_img);
    }

    @Override
    protected void initDatas() {
        List<SQBean> data = SQInstance.getInstance().queryById(1);
        Picasso.with(context).load(data.get(0).getImgUrl()).config(Bitmap.Config.RGB_565).into(coverImg);
        Log.d("PersonSingleFragment", "SQInstance.getInstance().queryAll().size():" + SQInstance.getInstance().queryAll().size() + "");
        int count = SQInstance.getInstance().queryAll().size();
        Log.d("PersonSingleFragment", "count:" + count);
        countTv.setText(count + "");
        coverImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonSingleDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
