package com.lanou3g.giltsay.utils;

/**
 * Created by dllo on 16/9/26.
 * RecyclerView的行点击接口
 */
public interface RecyclerViewItemClick {
    void onRvItemClickListener(int position, String str);
    void onRvItemClickListeners(int position,String str, String str1,String str2);
}
