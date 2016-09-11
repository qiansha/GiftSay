package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lanou3g.giltsay.*;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeleHorBean;

import java.util.List;

/**
 * Created by dllo on 16/9/11.
 */
public class HomePageSelectedHorAdapter extends BaseAdapter{
    private Context context;
    private List<HomeSeleHorBean>datas;

    public void setDatas(List<HomeSeleHorBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public HomePageSelectedHorAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas !=null && datas.size()> 0 ? datas.size() : 0;
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
        ViewHolder viewHolder = null;
        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_homepage_selected_horizontal,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.homeSelHorImg.setImageResource(datas.get(position).getImg());

        return convertView;
    }
    class ViewHolder{
       private ImageView homeSelHorImg;
        public ViewHolder(View view){
           homeSelHorImg = (ImageView) view.findViewById(R.id.item_home_sele_hor_img);
        }
    }
}
