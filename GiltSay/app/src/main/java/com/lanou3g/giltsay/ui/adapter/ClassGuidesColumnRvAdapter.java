package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassGuidesColumnRvBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 分类攻略中栏目RecyclerView的适配器
 */
public class ClassGuidesColumnRvAdapter extends RecyclerView.Adapter<ClassGuidesColumnRvAdapter.ClassGuidesColumnRvViewHolder> {
    private Context context;
    private List<ClassGuidesColumnRvBean.DataBean.ColumnsBean> datas;

    public ClassGuidesColumnRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassGuidesColumnRvBean.DataBean.ColumnsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ClassGuidesColumnRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_guides_column_rv, parent, false);
        ClassGuidesColumnRvViewHolder classGuidesColumnRvViewHolder = new ClassGuidesColumnRvViewHolder(view);
        return classGuidesColumnRvViewHolder;
    }

    @Override
    public void onBindViewHolder(ClassGuidesColumnRvViewHolder holder, int position) {
        ClassGuidesColumnRvBean.DataBean.ColumnsBean bean = datas.get(position);
        if (bean != null) {
            holder.classColumnTitle.setText(bean.getTitle());
            holder.classColumnSubTitle.setText(bean.getSubtitle());
            holder.classColumnAuthor.setText(bean.getAuthor());
        }
        Picasso.with(context).load(bean.getBanner_image_url()).config(Bitmap.Config.RGB_565).into(holder.classColumnImg);

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class ClassGuidesColumnRvViewHolder extends RecyclerView.ViewHolder {
        ImageView classColumnImg;
        TextView classColumnTitle;
        TextView classColumnSubTitle;
        TextView classColumnAuthor;

        public ClassGuidesColumnRvViewHolder(View itemView) {
            super(itemView);
            classColumnImg = (ImageView) itemView.findViewById(R.id.item_class_column_img_rv);
            classColumnTitle = (TextView) itemView.findViewById(R.id.item_class_column_rv_title_tv);
            classColumnSubTitle = (TextView) itemView.findViewById(R.id.item_class_column_rv_subtitle_tv);
            classColumnAuthor = (TextView) itemView.findViewById(R.id.item_class_column_rv_author_tv);
        }
    }
}
