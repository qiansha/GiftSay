package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassSingleBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * ReGridView的适配器
 */
public class ClassSingleRightGvAdapter extends BaseAdapter {
    private Context context;
    private List<ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean> datas;

    public ClassSingleRightGvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ClassSingleRightGvViewHolder classSingleRightGvViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_class_single_gv, parent, false);
            classSingleRightGvViewHolder = new ClassSingleRightGvViewHolder(convertView);
            convertView.setTag(classSingleRightGvViewHolder);
        } else {
            classSingleRightGvViewHolder = (ClassSingleRightGvViewHolder) convertView.getTag();
        }
        ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean bean = (ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean) getItem(position);
        classSingleRightGvViewHolder.rightGvTv.setText(bean.getName());
        Picasso.with(context).load(bean.getIcon_url()).config(Bitmap.Config.RGB_565).into(classSingleRightGvViewHolder.rightGvImg);
        return convertView;
    }


    class ClassSingleRightGvViewHolder {
        ImageView rightGvImg;
        TextView rightGvTv;

        public ClassSingleRightGvViewHolder(View view) {

            rightGvImg = (ImageView) view.findViewById(R.id.class_single_gv_img);
            rightGvTv = (TextView) view.findViewById(R.id.class_single_gv_tv);
        }
    }
}
