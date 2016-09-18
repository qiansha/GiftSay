package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeRotateBean;

import java.util.List;

/**
 * Created by dllo on 16/9/17.
 */
public class HomeSeleRotateAdapter extends PagerAdapter {
    private List<HomeSeRotateBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public HomeSeleRotateAdapter(List<HomeSeRotateBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public HomeSeleRotateAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HomeSeRotateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_homepage_sele_rotate_vp, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_sele_rotate_iv);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        container.addView(convertView);
        return convertView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
