package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ClassGuidesColumnDetailBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/8.
 */
public class ClassGuidesColumnDetailLvAdapter extends BaseAdapter {
    private Context context;
    private List<ClassGuidesColumnDetailBean.DataBean.PostsBean>datas;

    public ClassGuidesColumnDetailLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ClassGuidesColumnDetailBean.DataBean.PostsBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DetailViewHolder detailViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_class_column_detail_lv,parent,false);
            detailViewHolder = new DetailViewHolder(convertView);
            convertView.setTag(detailViewHolder);
        }else {
            detailViewHolder = (DetailViewHolder) convertView.getTag();
        }

        ClassGuidesColumnDetailBean.DataBean.PostsBean been =  datas.get(position);
        Log.d("ClassGuidesColumnDetail", "been:" + been);
//        Log.d("ClassGuidesColumnDetail", "been.getLikes_count():" + been.getLikes_count() +);
        if (been !=null) {
            detailViewHolder.titleTv.setText(been.getTitle());
            detailViewHolder.likeCountTv.setText(been.getLikes_count() + "");
            detailViewHolder.authorTv.setText(been.getAuthor().getNickname());
            Picasso.with(context).load(been.getCover_image_url()).config(Bitmap.Config.RGB_565).into(detailViewHolder.coverImg);
        }
        return convertView;
    }
   class DetailViewHolder{
       ImageView coverImg;
       ImageView heartImg;
       TextView titleTv,authorTv,likeCountTv;
       public  DetailViewHolder(View view){
           coverImg = (ImageView) view.findViewById(R.id.item_class_detail_column_cover_img);
           heartImg = (ImageView) view.findViewById(R.id.item_class_detail_column_like_img);
           titleTv = (TextView) view.findViewById(R.id.item_class_detail_column_title_tv);
           authorTv = (TextView) view.findViewById(R.id.item_class_detail_column_name_tv);
           likeCountTv = (TextView) view.findViewById(R.id.item_class_detail_column_likecount_tv);
       }
   }
}
