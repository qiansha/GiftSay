package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListPageRecyclerViewBean;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 榜单的适配器
 */
public class ListPageRvAdapter extends RecyclerView.Adapter<ListPageRvAdapter.ListViewHolder> {
    private Context context;
    private RecyclerViewItemClick recyclerViewItemClick;
    private List<ListPageRecyclerViewBean.DataBean.ItemsBean> datas;

    public void setRecyclerViewItemClick(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    public ListPageRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ListPageRecyclerViewBean.DataBean.ItemsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listpage_rv, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        Log.d("ListPageRvAdapter", "进来没?");
        final ListPageRecyclerViewBean.DataBean.ItemsBean bean = datas.get(position);
        if (bean != null) {
            Log.d("ListPageRvAdapter", bean.getName() + "名字");
            Log.d("ListPageRvAdapter", bean.getDescription() + "描述");
            Log.d("ListPageRvAdapter", bean.getPrice() + "价格");
            holder.listNameTv.setText(bean.getName());
            holder.listDescriptionTv.setText(bean.getShort_description());
            holder.listPriceTv.setText(bean.getPrice());
            Picasso.with(context).load(bean.getCover_image_url()).config(Bitmap.Config.RGB_565).into(holder.listImg);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewItemClick != null) {
                    int p = holder.getLayoutPosition();
                    recyclerViewItemClick.onRvItemClickListener(p, null);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView listImg;
        TextView listDescriptionTv;
        TextView listNameTv;
        TextView listPriceTv;

        public ListViewHolder(View itemView) {
            super(itemView);
            listImg = (ImageView) itemView.findViewById(R.id.listpage_cv_img);
            listDescriptionTv = (TextView) itemView.findViewById(R.id.listpage_cv_description_tv);
            listNameTv = (TextView) itemView.findViewById(R.id.listpage_cv_name_tv);
            listPriceTv = (TextView) itemView.findViewById(R.id.listpage_cv_price_tv);

        }
    }
}
