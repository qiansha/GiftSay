package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.HomeSeRotateBean;
import com.lanou3g.giltsay.ui.activity.HomePageDetailActivity;
import com.lanou3g.giltsay.ui.activity.RotateDetailActivity;
import com.lanou3g.giltsay.ui.activity.RotateDetailNoIdActivity;
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
    private List<HomeSeRotateBean.DataBean.BannersBean> datas;
    private Context context;
    private LayoutInflater inflater;


    public HomeSeleRotateAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HomeSeRotateBean.DataBean.BannersBean> datas) {
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

        final HomeSeRotateBean.DataBean.BannersBean bean = datas.get(newPosition);
        Picasso.with(context).load(bean.getImage_url()).config(Bitmap.Config.RGB_565).into(imageView);
//        Picasso.with(context).load(bean.getImgUrl).config(Bitmap.Config.RGB_565).config(imageView);
        container.addView(convertView);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RotateDetailActivity.class);
                Object id =  bean.getTarget_id();
//                String ids = String.v

                if (id!=null) {
                    String index = String.valueOf(id);
                    Log.d("aaaa", "zhixing");
                    intent.putExtra("target_id",index);
//                    intent.putExtra("target_url","111");
                    context.startActivity(intent);
                }else {
                    Intent intent1 = new Intent(context, RotateDetailNoIdActivity.class);
//                    intent.putExtra("target_id","");
                    intent1.putExtra("target_url",bean.getTarget_url());
                    context.startActivity(intent1);
                }


            }
        });
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
