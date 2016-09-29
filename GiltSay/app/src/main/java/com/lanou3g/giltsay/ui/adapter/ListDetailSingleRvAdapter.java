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
import com.lanou3g.giltsay.model.bean.ListDetailBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 榜单详情中单品RecyclerView的适配器
 */
public class ListDetailSingleRvAdapter extends RecyclerView.Adapter<ListDetailSingleRvAdapter.ListDetailSingleViewHolder>{
    private Context context;
    private List<ListDetailBean.DataBean.RecommendItemsBean>datas;

    public ListDetailSingleRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ListDetailBean.DataBean.RecommendItemsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ListDetailSingleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_detail_single_rv,parent,false);
        ListDetailSingleViewHolder listDetailSingleViewHolder = new ListDetailSingleViewHolder(view);
        return listDetailSingleViewHolder;
    }

    @Override
    public void onBindViewHolder(ListDetailSingleViewHolder holder, int position) {
        ListDetailBean.DataBean.RecommendItemsBean bean =  datas.get(position);
        holder.detailSingleNameTv.setText(bean.getName());
        holder.detailSinglePriceTv.setText(bean.getPrice());
        Picasso.with(context).load(bean.getCover_image_url()).config(Bitmap.Config.RGB_565).fit().into(holder.detailSingleImg);
    }

    @Override
    public int getItemCount() {
        return datas == null  ? 0 : datas.size();
    }

    class ListDetailSingleViewHolder extends RecyclerView.ViewHolder{
        ImageView detailSingleImg;
        TextView detailSingleNameTv;
        TextView detailSinglePriceTv;

        public ListDetailSingleViewHolder(View itemView) {
            super(itemView);
            detailSingleImg = (ImageView) itemView.findViewById(R.id.list_detail_cv_img);
            detailSingleNameTv = (TextView) itemView.findViewById(R.id.list_detail_cv_description_tv);
            detailSinglePriceTv = (TextView) itemView.findViewById(R.id.list_detail_cv_price_tv);
        }
    }
}
