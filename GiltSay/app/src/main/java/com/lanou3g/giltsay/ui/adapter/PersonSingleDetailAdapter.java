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
import com.lanou3g.giltsay.model.bean.SQBean;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 个人单品详情适配器
 */
public class PersonSingleDetailAdapter extends RecyclerView.Adapter<PersonSingleDetailAdapter.ViewHolder>{
    private Context context;
    private List<SQBean>datas;
    private RecyclerViewItemClick recyclerViewItemClick;

    public void setRecyclerViewItemClick(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    public PersonSingleDetailAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SQBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listpage_rv,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final SQBean bean = datas.get(position);
        holder.listDescriptionTv.setText(bean.getDescription());
        holder.listNameTv.setText(bean.getName());
        holder.listPriceTv.setText(bean.getPrice());
        Picasso.with(context).load(bean.getImgUrl()).config(Bitmap.Config.RGB_565).into(holder.listImg);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (recyclerViewItemClick != null){
                   int p = holder.getLayoutPosition();
                   recyclerViewItemClick.onRvItemClickListener(p,null);
               }
           }
       });

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView listImg;
        TextView listDescriptionTv;
        TextView listNameTv;
        TextView listPriceTv;

        public ViewHolder(View itemView) {
            super(itemView);
            listImg = (ImageView) itemView.findViewById(R.id.listpage_cv_img);
            listDescriptionTv = (TextView) itemView.findViewById(R.id.listpage_cv_description_tv);
            listNameTv = (TextView) itemView.findViewById(R.id.listpage_cv_name_tv);
            listPriceTv = (TextView) itemView.findViewById(R.id.listpage_cv_price_tv);

        }
    }
}
