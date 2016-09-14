package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleRvBean;

import java.util.List;

/**
 * Created by dllo on 16/9/11.
 * 精选页面RecyclerView的适配器
 */
public class HomePageSelectedRvAdapter extends RecyclerView.Adapter<HomePageSelectedRvAdapter.HomeSeleRvViewHolder> {
    private Context context;
    private List<HomeSeleRvBean> datas;

    public void setDatas(List<HomeSeleRvBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public HomePageSelectedRvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public HomeSeleRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_homepage_selected_rv, parent, false);
        HomeSeleRvViewHolder homeSeleRvViewHolder = new HomeSeleRvViewHolder(view);
        return homeSeleRvViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeSeleRvViewHolder holder, int position) {
        holder.homeSeleImg.setImageResource(datas.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class HomeSeleRvViewHolder extends RecyclerView.ViewHolder {
        private ImageView homeSeleImg;

        public HomeSeleRvViewHolder(View itemView) {
            super(itemView);
            homeSeleImg = (ImageView) itemView.findViewById(R.id.item_home_sele_rv_img);
        }
    }
}
