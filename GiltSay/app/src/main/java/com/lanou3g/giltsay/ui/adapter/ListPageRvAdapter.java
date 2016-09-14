package com.lanou3g.giltsay.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;

/**
 * Created by dllo on 16/9/14.
 * 榜单的适配器
 */
public class ListPageRvAdapter extends RecyclerView.Adapter<ListPageRvAdapter.ListViewHolder>{
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView listImg;
        TextView listDescriptionTv;
        TextView listNameTv;

        public ListViewHolder(View itemView) {
            super(itemView);
            listImg = (ImageView) itemView.findViewById(R.id.listpage_cv_img);
            listDescriptionTv = (TextView) itemView.findViewById(R.id.listpage_cv_description_tv);
            listNameTv = (TextView) itemView.findViewById(R.id.listpage_cv_name_tv);
        }
    }
}
