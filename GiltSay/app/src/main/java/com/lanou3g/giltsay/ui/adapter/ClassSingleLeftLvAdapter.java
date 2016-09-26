package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassSingleBean;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 分类单品左边ListView适配器
 */
public class ClassSingleLeftLvAdapter extends BaseAdapter {
    private Context context;
    private List<ClassSingleBean.DataBean.CategoriesBean> datas;
    private int selectIndex;

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    public ClassSingleLeftLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassSingleBean.DataBean.CategoriesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
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
        ClassSingleLeftLvViewHolder classSingleLeftLvViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_class_single_lv, parent, false);
            classSingleLeftLvViewHolder = new ClassSingleLeftLvViewHolder(convertView);
            convertView.setTag(classSingleLeftLvViewHolder);
        } else {
            classSingleLeftLvViewHolder = (ClassSingleLeftLvViewHolder) convertView.getTag();
        }
        ClassSingleBean.DataBean.CategoriesBean bean = datas.get(position);
        if (bean != null) {
            classSingleLeftLvViewHolder.classSingleLeftTv.setText(bean.getName());
        }
        if (position == selectIndex) {
            classSingleLeftLvViewHolder.classSingleLeftTv.setTextColor(StaticClassHelper.myColor);
            classSingleLeftLvViewHolder.classSingleLeftTv.setBackgroundColor(StaticClassHelper.seleBgColor);
            classSingleLeftLvViewHolder.classSingleLeftView.setBackgroundColor(StaticClassHelper.myColor);

        } else {
            classSingleLeftLvViewHolder.classSingleLeftTv.setTextColor(StaticClassHelper.noSeleColor);
            classSingleLeftLvViewHolder.classSingleLeftTv.setBackgroundColor(StaticClassHelper.noSeleBgColor);
            classSingleLeftLvViewHolder.classSingleLeftView.setBackgroundColor(StaticClassHelper.noSeleBgColor);
        }
        return convertView;
    }

    class ClassSingleLeftLvViewHolder {
        TextView classSingleLeftTv;
        View classSingleLeftView;

        public ClassSingleLeftLvViewHolder(View view) {
            classSingleLeftTv = (TextView) view.findViewById(R.id.class_single_lv_tv);
            classSingleLeftView = (View) view.findViewById(R.id.class_single_view);

        }
    }
}
