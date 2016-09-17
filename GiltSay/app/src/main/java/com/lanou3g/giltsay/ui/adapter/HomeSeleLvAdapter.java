package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.giltsay.*;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleBean;
import com.lanou3g.giltsay.model.bean.HomeSeleLvBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dllo on 16/9/12.
 */
public class HomeSeleLvAdapter extends BaseAdapter {
    private String authorImgUrl = "http://img01.liwushuo.com/image/160902/pkwjxp8s1.jpg";
    private Context context;
    private List<HomeSeleBean.DataBean.ItemsBean> datas;

    public HomeSeleLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomeSeleBean.DataBean.ItemsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


//    public void setDatas(List<HomeSeleBean.DataBean> datas) {
//        this.datas = datas;
//        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeSeleLvViewHolder homeSeleLvViewHolder = null;
        Log.d("zzz", "111111");
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_homepage_selected_lv, parent, false);
            homeSeleLvViewHolder = new HomeSeleLvViewHolder(convertView);
            convertView.setTag(homeSeleLvViewHolder);
        } else {
            homeSeleLvViewHolder = (HomeSeleLvViewHolder) convertView.getTag();
        }
        //HomeSeleLvBean homeSeleLvBean = new HomeSeleLvBean();
        HomeSeleBean.DataBean.ItemsBean bean = (HomeSeleBean.DataBean.ItemsBean) getItem(position);
        Log.d("zzz", "zhixing");
        if (bean != null) {
            if (bean.getColumn() != null) {
                homeSeleLvViewHolder.categoryTv.setText(bean.getColumn().getCategory());
                homeSeleLvViewHolder.descriptionTv.setText(bean.getTitle());
                homeSeleLvViewHolder.titleTv.setText(bean.getColumn().getTitle());

            }
            homeSeleLvViewHolder.nicknameTv.setText(bean.getAuthor().getNickname());

            homeSeleLvViewHolder.likesCountTv.setText(bean.getLikes_count() + "");
            Picasso.with(context).load(bean.getCover_image_url()).into(homeSeleLvViewHolder.coverImg);
            Picasso.with(context).load(bean.getAuthor().getAvatar_url()).into(homeSeleLvViewHolder.authorImg);
            Log.d("HomePageSelectedFragmen", datas.get(position).getTitle() + "null");
        }
        return convertView;
    }

    class HomeSeleLvViewHolder {
        TextView categoryTv, descriptionTv, nicknameTv, titleTv, likesCountTv;
        ImageView authorImg;
        ImageView coverImg;

        public HomeSeleLvViewHolder(View view) {
            categoryTv = (TextView) view.findViewById(R.id.homesele_list_cateory_tv);
            descriptionTv = (TextView) view.findViewById(R.id.homesele_list_description_tv);
            nicknameTv = (TextView) view.findViewById(R.id.homesele_list_nickname_tv);
            titleTv = (TextView) view.findViewById(R.id.homesele_list_title_tv);
            likesCountTv = (TextView) view.findViewById(R.id.homesele_list_likes_count_tv);
            authorImg = (ImageView) view.findViewById(R.id.homesele_list_author_img);
            coverImg = (ImageView) view.findViewById(R.id.homesele_list_big_img);

        }
    }
}
