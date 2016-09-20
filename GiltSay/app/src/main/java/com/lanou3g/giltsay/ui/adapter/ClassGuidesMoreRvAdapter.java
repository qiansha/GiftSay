package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassGuidesColumnRvBean;
import com.lanou3g.giltsay.model.bean.ClassGuidesMoreRvBean;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 分类中品类,风格,对象RecyclerView的适配器
 */
public class ClassGuidesMoreRvAdapter extends RecyclerView.Adapter {
    private List<ClassGuidesColumnRvBean.DataBean.ColumnsBean> columnDatas;
    private Context context;
    private List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean.ChannelsBean> datas;

    public ClassGuidesMoreRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean.ChannelsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setColumnDatas(List<ClassGuidesColumnRvBean.DataBean.ColumnsBean> columnDatas) {
        this.columnDatas = columnDatas;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_guides_more_img_rv, parent, false);
        ClassGuidesMoreImgViewHolder holder = new ClassGuidesMoreImgViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ClassGuidesMoreImgViewHolder imgViewHolder = (ClassGuidesMoreImgViewHolder) holder;
        ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean.ChannelsBean bean = datas.get(position);
        Picasso.with(context).load(bean.getCover_image_url()).into(imgViewHolder.classMoreImg);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class ClassGuidesMoreImgViewHolder extends RecyclerView.ViewHolder {
        ImageView classMoreImg;

        public ClassGuidesMoreImgViewHolder(View itemView) {
            super(itemView);
            classMoreImg = (ImageView) itemView.findViewById(R.id.item_class_more_img_rv);
        }
    }
}
