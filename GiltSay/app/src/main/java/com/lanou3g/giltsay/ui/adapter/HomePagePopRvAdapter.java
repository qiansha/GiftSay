package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomePopRvBean;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.lanou3g.giltsay.utils.StaticClassHelper;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * PopWindow中RecyclerView的适配器
 */
public class HomePagePopRvAdapter extends RecyclerView.Adapter<HomePagePopRvAdapter.HomePagePopRvViewHolder> {
    private Context context;
    private List<String> data;
    private RecyclerViewItemClick recyclerViewItemClick;
    private int selectedIndex;
    private boolean flag = false;

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        notifyDataSetChanged();
    }

    public void setRecyclerViewItemClick(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    public HomePagePopRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public HomePagePopRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_homepage_pop_rv, parent, false);
        HomePagePopRvViewHolder homePagePopRvViewHolder = new HomePagePopRvViewHolder(view);
        return homePagePopRvViewHolder;
    }

    @Override
    public void onBindViewHolder(final HomePagePopRvViewHolder holder, final int position) {
        String[] popStr = {"精选", "送男票", "穿搭", "海淘", "礼物", "美护", "送闺蜜", "送爸妈",
                "送基友", "送同事", "送宝贝", "创意生活", "手工", "设计感", "文艺风", "科技范", "奇葩搞怪", "萌萌哒"};
        holder.popTv.setText(data.get(position));
        if (position == selectedIndex) {
            holder.popTv.setTextColor(StaticClassHelper.myColor);
            holder.popView.setBackgroundColor(StaticClassHelper.myColor);

        } else {
            holder.popTv.setTextColor(StaticClassHelper.noSeleColor);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewItemClick != null) {
                    int p = holder.getLayoutPosition();
                    String str = data.get(position);
                    recyclerViewItemClick.onRvItemClickListener(p, str);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class HomePagePopRvViewHolder extends RecyclerView.ViewHolder {
        TextView popTv;
        View popView;

        public HomePagePopRvViewHolder(View itemView) {
            super(itemView);
            popTv = (TextView) itemView.findViewById(R.id.item_homepage_pop_tv);
            popView = itemView.findViewById(R.id.item_homepage_pop_view);
        }
    }
}
