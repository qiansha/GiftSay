package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
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
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.lanou3g.giltsay.view.ReGridView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 攻略单品中右侧的ListView
 */
public class ClassSingleRightListViewAdapter extends BaseAdapter {
//    private int selectIndex;
    private Context context;
    private ClassSingleRightGvAdapter classSingleRightGvAdapter;
    private List<ClassSingleBean.DataBean.CategoriesBean> data;

//    public void setSelectIndex(int selectIndex) {
//        this.selectIndex = selectIndex;
//    }

    public ClassSingleRightListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassSingleBean.DataBean.CategoriesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null && data.size() > 0 ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RightLvViewHolderView rightLvViewHolderView = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_class_single_right_listview, parent, false);
            rightLvViewHolderView = new RightLvViewHolderView(convertView);
            convertView.setTag(rightLvViewHolderView);
        } else {
            rightLvViewHolderView = (RightLvViewHolderView) convertView.getTag();
        }
        ClassSingleBean.DataBean.CategoriesBean bean = data.get(position);
        classSingleRightGvAdapter = new ClassSingleRightGvAdapter(context);
        classSingleRightGvAdapter.setDatas(bean.getSubcategories());
        rightLvViewHolderView.singleGv.setAdapter(classSingleRightGvAdapter);
        rightLvViewHolderView.rightTitleTv.setText(bean.getName());
        return convertView;
    }

    class RightLvViewHolderView {
        ReGridView singleGv;
        TextView rightTitleTv;

        public RightLvViewHolderView(View view) {
            singleGv = (ReGridView) view.findViewById(R.id.item_class_rightlv_rgv);
            rightTitleTv = (TextView) view.findViewById(R.id.item_class_single_rightlv_title_tv);

        }
    }
}
