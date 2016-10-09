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
import com.lanou3g.giltsay.model.bean.RotateDetailBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/10/8.
 */
public class RotateDetailAdapter extends BaseAdapter{
    private List<RotateDetailBean.DataBean.PostsBean>datas;
    private Context context;

    public RotateDetailAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<RotateDetailBean.DataBean.PostsBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ?datas.size() : 0;
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
        RotateDetailViewHolder rotateDetailViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_rotate_detail_lv,parent,false);
            rotateDetailViewHolder = new RotateDetailViewHolder(convertView);
            convertView.setTag(rotateDetailViewHolder);
        }else {
            rotateDetailViewHolder = (RotateDetailViewHolder) convertView.getTag();
        }
        RotateDetailBean.DataBean.PostsBean bean = (RotateDetailBean.DataBean.PostsBean) getItem(position);
        if (bean != null) {
            if (bean.getColumn() != null) {
                rotateDetailViewHolder.categoryTv.setText(bean.getColumn().getCategory());
                rotateDetailViewHolder.descriptionTv.setText(bean.getTitle());
                rotateDetailViewHolder.titleTv.setText(bean.getColumn().getTitle());

            }
            rotateDetailViewHolder.nicknameTv.setText(bean.getAuthor().getNickname());
            rotateDetailViewHolder.likesCountTv.setText(bean.getLikes_count() + "");
            Picasso.with(context).load(bean.getCover_image_url()).config(Bitmap.Config.RGB_565).into(rotateDetailViewHolder.coverImg);
            Picasso.with(context).load(bean.getAuthor().getAvatar_url()).config(Bitmap.Config.RGB_565).into(rotateDetailViewHolder.authorImg);
            Log.d("HomePageSelectedFragmen", datas.get(position).getTitle() + "null");
        }
        return convertView;
    }
    class RotateDetailViewHolder{
        TextView categoryTv, descriptionTv, nicknameTv, titleTv, likesCountTv;
        CircleImageView authorImg;
        ImageView coverImg;
       public RotateDetailViewHolder(View view){
           categoryTv = (TextView) view.findViewById(R.id.rotate_detail_list_cateory_tv);
           descriptionTv = (TextView) view.findViewById(R.id.rotate_detail_list_description_tv);
           nicknameTv = (TextView) view.findViewById(R.id.rotate_detail_list_nickname_tv);
           titleTv = (TextView) view.findViewById(R.id.rotate_detail_list_title_tv);
           likesCountTv = (TextView) view.findViewById(R.id.rotate_detail_list_likes_count_tv);
           authorImg = (CircleImageView) view.findViewById(R.id.rotate_detail_list_author_img);
           coverImg = (ImageView) view.findViewById(R.id.rotate_detail_list_big_img);
       }
    }
}
