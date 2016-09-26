package com.lanou3g.giltsay.model.net;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by dllo on 16/9/26.
 * 内存缓存
 */
public class MemoryCache  implements ImageLoader.ImageCache{
    //最近最少使用算法
    private LruCache<String,Bitmap>chahe;
    public MemoryCache(){
        //手机最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        //分配给图片缓存的内存   做单位换算和分配空间
        int maxSize = (int) (maxMemory/1024/4);
        chahe = new LruCache<String,Bitmap>(maxSize){
            //设置每张图片占据的内存

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return chahe.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        chahe.put(url,bitmap);

    }
}
