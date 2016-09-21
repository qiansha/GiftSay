package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassSingleBean;
import com.lanou3g.giltsay.view.ReGridView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 攻略单品中右侧的ListView
 */
public class ClassSingleRightListViewAdapter extends BaseAdapter{
    private int selectIndex;
    private Context context;
    private List<ReGridView>datas;
    private ClassSingleRightGvAdapter classSingleRightGvAdapter;
    private List<ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean>data;

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }
    //
//    public void setClassSingleRightRvAdapter(ClassSingleRightRvAdapter classSingleRightRvAdapter) {
//        this.classSingleRightRvAdapter = classSingleRightRvAdapter;
//    }

    public ClassSingleRightListViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

//    public void setDatas(List<RecyclerView> datas) {
//        this.datas = datas;
//        notifyDataSetChanged();
//    }

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

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_class_single_right_listview,parent,false);
            rightLvViewHolderView = new RightLvViewHolderView(convertView);
            convertView.setTag(rightLvViewHolderView);
        }else {
            rightLvViewHolderView = (RightLvViewHolderView) convertView.getTag();
        }
        ClassSingleBean.DataBean.CategoriesBean.SubcategoriesBean bean = data.get(position);
       classSingleRightGvAdapter = new ClassSingleRightGvAdapter(context);
        classSingleRightGvAdapter.setDatas(bean.);
        rightLvViewHolderView.singleGv.setAdapter(classSingleRightGvAdapter);

//        Picasso.with(context).load(bean.getIcon_url()).into(rightLvViewHolderView.rightImg);
//        GridLayoutManager gm = new GridLayoutManager(context,3, LinearLayoutManager.VERTICAL,false);
//        classSingleRightRvAdapter  = new ClassSingleRightRvAdapter(context);

//        classSingleRightRvAdapter.setDatas(bean.get(position).getName());
//        rightLvViewHolderView.singleRv.setAdapter(classSingleRightRvAdapter);
//
//        rightLvViewHolderView.singleRv.setLayoutManager(gm);
        return convertView;
    }
    class RightLvViewHolderView{
//        ImageView rightImg;
//        TextView rightTv;
        ReGridView singleGv;
        public RightLvViewHolderView(View view){
            singleGv = (ReGridView) view.findViewById(R.id.item_class_rightlv_rgv);
//            rightImg = (ImageView) view.findViewById(R.id.item_class_single_rightlv_img);
//            rightTv = (TextView) view.findViewById(R.id.item_class_single_rightlv_tv);


        }
    }
}
