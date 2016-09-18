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
 */
public class ClassGuidesMoreRvAdapter extends RecyclerView.Adapter{
    private List<ClassGuidesColumnRvBean.DataBean.ColumnsBean>columnDatas;
    private Context context;
    private List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean> datas;

    public ClassGuidesMoreRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setColumnDatas(List<ClassGuidesColumnRvBean.DataBean.ColumnsBean> columnDatas) {
        this.columnDatas = columnDatas;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case 0:
                View columnView = LayoutInflater.from(context).inflate(R.layout.item_class_guides_column_rv,parent,false);
                holder = new ClassGuidesColumnRvViewHolder(columnView);
                 break;
            case 1:
                View v = LayoutInflater.from(context).inflate(R.layout.item_class_guides_more_title_rv,parent,false);
                holder = new ClassGuidesMoreTitleViewHolder(v);
                break;
            case 2:
                View view = LayoutInflater.from(context).inflate(R.layout.item_class_guides_more_img_rv,parent,false);
                holder = new ClassGuidesMoreImgViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = getItemViewType(position);
        switch (type){
            case 0:
                ClassGuidesColumnRvViewHolder columnViewHolder = (ClassGuidesColumnRvViewHolder) holder;
                ClassGuidesColumnRvBean.DataBean.ColumnsBean columnBean = columnDatas.get(position);
                if (columnBean != null){
                    columnViewHolder.classColumnTitle.setText(columnBean.getTitle());
                    columnViewHolder.classColumnSubTitle.setText(columnBean.getSubtitle());
                    columnViewHolder.classColumnAuthor.setText(columnBean.getAuthor());
                }
                Picasso.with(context).load(columnBean.getBanner_image_url()).into(columnViewHolder.classColumnImg);

            case 1:
                //ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean bean =g;
                        ClassGuidesMoreTitleViewHolder titleViewHolder = (ClassGuidesMoreTitleViewHolder) holder;
                titleViewHolder.classMoreTitle.setText("风格");
                break;
            case 2:
                ClassGuidesMoreImgViewHolder imgViewHolder = (ClassGuidesMoreImgViewHolder) holder;
                ClassGuidesMoreRvBean.DataBean.ChannelGroupsBean bean = datas.get(position);
                Picasso.with(context).load(bean.getChannels().get(position).getCover_image_url()).into(imgViewHolder.classMoreImg);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    class ClassGuidesMoreImgViewHolder extends RecyclerView.ViewHolder{
        ImageView classMoreImg;


        public ClassGuidesMoreImgViewHolder(View itemView) {
            super(itemView);
            classMoreImg = (ImageView) itemView.findViewById(R.id.item_class_more_img_rv);

        }
    }
    class ClassGuidesMoreTitleViewHolder extends RecyclerView.ViewHolder{
        TextView  classMoreTitle;


        public ClassGuidesMoreTitleViewHolder(View itemView) {
            super(itemView);
            classMoreTitle = (TextView) itemView.findViewById(R.id.item_class_more_title_rv);

        }
    }
    class ClassGuidesColumnRvViewHolder extends RecyclerView.ViewHolder{
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
