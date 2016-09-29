package com.lanou3g.giltsay.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.model.bean.ListDeManyImgBean;
import com.lanou3g.giltsay.model.bean.ListDetaliHTMLBean;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dllo on 16/9/29.
 * 榜单详情中单品单品图片V拍的适配器
 */
public class ListDetailSingleManyImgAdapter extends PagerAdapter {
    private Context context;
    private List<ListDeManyImgBean> datas;
    private LayoutInflater inflater;

    public ListDetailSingleManyImgAdapter(Context context, List<ListDeManyImgBean> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<ListDeManyImgBean> datas) {
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
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View view = inflater.inflate(R.layout.item_list_desingle_vp, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.list_single_vp_img);

        Picasso.with(context).load(datas.get(newPosition).getImgUrl()).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
