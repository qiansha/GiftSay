package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeRotateBean;
import com.lanou3g.giltsay.ui.activity.HomePageDetailActivity;
import com.lanou3g.giltsay.ui.activity.RotateDetailActivity;
import com.lanou3g.giltsay.utils.RecyclerViewItemClick;
import com.lanou3g.giltsay.utils.StaticClassHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/17.
 * 首页精选轮播图适配器
 */
public class HomeSeleRotateAdapter extends PagerAdapter {
    private List<HomeSeRotateBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public HomeSeleRotateAdapter(List<HomeSeRotateBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public HomeSeleRotateAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HomeSeRotateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        final int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_homepage_sele_rotate_vp, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_sele_rotate_iv);

        final HomeSeRotateBean bean = datas.get(newPosition);
        Picasso.with(context).load(bean.getImgUrl()).config(Bitmap.Config.RGB_565).into(imageView);
//        Picasso.with(context).load(bean.getImgUrl).config(Bitmap.Config.RGB_565).config(imageView);
        container.addView(convertView);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,RotateDetailActivity.class);
                if (bean.getData().getBanners().get(newPosition).getTarget_id() != null){
                        intent.putExtra("target_id",bean.getData().getBanners().get(position).getTarget_id() + "");}
//                        intent.putExtra("title",bean.getData().getBanners().get(newPosition).getC);
                        context.startActivity(intent);

            }
        });
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
