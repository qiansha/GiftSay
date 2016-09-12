package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.giltsay.*;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleLvBean;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dllo on 16/9/12.
 */
public class HomeSeleLvAdapter extends BaseAdapter{
    private Context context;
    private List<HomeSeleLvBean>datas;

    public HomeSeleLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomeSeleLvBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return  datas !=null && datas.size() > 0 ?datas.size():0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeSeleLvViewHolder homeSeleLvViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_homepage_selected_lv,parent,false);
            homeSeleLvViewHolder = new HomeSeleLvViewHolder(convertView);
            convertView.setTag(homeSeleLvViewHolder);
        }else {
            homeSeleLvViewHolder = (HomeSeleLvViewHolder) convertView.getTag();
        }
        //HomeSeleLvBean homeSeleLvBean = new HomeSeleLvBean();
        homeSeleLvViewHolder.categoryTv.setText(datas.get(position).getCategory());
        homeSeleLvViewHolder.descriptionTv.setText(datas.get(position).getDescription());
        homeSeleLvViewHolder.nicknameTv.setText(datas.get(position).getNickname());
        homeSeleLvViewHolder.titleTv.setText(datas.get(position).getTitle());
        homeSeleLvViewHolder.likesCountTv.setText(datas.get(position).getLikesCount());
        return convertView;
    }
    class HomeSeleLvViewHolder{
        TextView categoryTv,descriptionTv,nicknameTv,titleTv,likesCountTv;
        public HomeSeleLvViewHolder(View view){
            categoryTv = (TextView) view.findViewById(R.id.homesele_list_cateory_tv);
            descriptionTv = (TextView) view.findViewById(R.id.homesele_list_description_tv);
            nicknameTv = (TextView) view.findViewById(R.id.homesele_nickname_tv);
            titleTv = (TextView) view.findViewById(R.id.homesele_nickname_tv);
            likesCountTv = (TextView) view.findViewById(R.id.homesele_list_likes_count_tv);

        }
    }
}
