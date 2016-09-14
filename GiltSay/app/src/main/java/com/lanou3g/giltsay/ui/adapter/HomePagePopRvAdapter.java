package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomePopRvBean;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * PopWindow中RecyclerView的适配器
 */
public class HomePagePopRvAdapter extends RecyclerView.Adapter<HomePagePopRvAdapter.HomePagePopRvViewHolder>{
    private Context context;
    private List<String> data;

    public HomePagePopRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public HomePagePopRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_homepage_pop_rv,parent,false);
        HomePagePopRvViewHolder homePagePopRvViewHolder = new HomePagePopRvViewHolder(view);
        return homePagePopRvViewHolder;
    }

    @Override
    public void onBindViewHolder(HomePagePopRvViewHolder holder, int position) {
        String[] popStr = {"精选","送男票", "穿搭", "海淘", "礼物", "美护", "送闺蜜", "送爸妈",
                "送基友", "送同事", "送宝贝", "创意生活", "手工", "设计感", "文艺风", "科技范", "奇葩搞怪", "萌萌哒"};


            holder.popTv.setText(data.get(position));
       // holder.popTv.setText("1111");


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class HomePagePopRvViewHolder extends RecyclerView.ViewHolder{
        TextView popTv;


        public HomePagePopRvViewHolder(View itemView) {
            super(itemView);
            popTv = (TextView) itemView.findViewById(R.id.item_homepage_pop_tv);
        }
    }
}
