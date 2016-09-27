package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleHorRvBean;
import com.lanou3g.giltsay.model.bean.HomeSeleRvBean;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/11.
 * 精选页面RecyclerView的适配器
 */
public class HomePageSelectedRvAdapter extends RecyclerView.Adapter<HomePageSelectedRvAdapter.HomeSeleRvViewHolder> {
    private Context context;
//    private List<HomeSeleRvBean> datas;
    private List<HomeSeleHorRvBean.DataBean.SecondaryBannersBean>datas;
    private RecyclerViewItemClick recyclerViewItemClick;

    public void setRecyclerViewItemClick(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    public void setDatas(List<HomeSeleHorRvBean.DataBean.SecondaryBannersBean> datas) {
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
    public void onBindViewHolder(final HomeSeleRvViewHolder holder, final int position) {
        Picasso.with(context).load(datas.get(position).getImage_url()).config(Bitmap.Config.RGB_565).into(holder.homeSeleImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (recyclerViewItemClick != null){
                    if (recyclerViewItemClick != null){
                        int p = holder.getLayoutPosition();
//                        String str = data.get(position);
//                        ImageView bitmap = holder.homeSeleImg;
                        String str = datas.get(position).getImage_url();
                        recyclerViewItemClick.onRvItemClickListener(p,str);
                    }
                }
            }
        });

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
