package com.lanou3g.giltsay.model.net;

import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.app.GiftApp;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by dllo on 16/9/26.
 * 图片的Volley单例
 */
public class ImageVolleyInstance {
    /**
     * 如何单例一个类的对象
     * 1.定义当前类的静态对象
     * 2.对外提供获取方法(单例方法)
     * 3.私有化构造方法
     */

    /**
     * 网络请求单例需要的内容
     * 1.定义请求队列并初始化
     * 2.提供请求方法
     */
    private RequestQueue queue;

    // 定义加载图片的ImageLoader
    private ImageLoader imageLoader;

    private ImageVolleyInstance() {
        queue = Volley.newRequestQueue(GiftApp.getContext());
        // 在构造方法中实例化ImageLoader
        imageLoader = new ImageLoader(queue, new MemoryCache());
    }

    private static VolleyInstance instance;

    public static VolleyInstance getInstance() {
        if (instance == null) {
            synchronized (VolleyInstance.class) {
                if (instance == null) {
                    instance = new VolleyInstance();
                }
            }
        }
        return instance;
    }
    /****************请求数据***********************/
    /**
     * 对外提供的请求方法
     */
    public void startRequest(String url, ImageVolleuResult result, int who) {
        _startRequest(url, result, who);
    }

    // 其他: 可以规定请求方法
//    public static void startRequest(int method,String url, IVolleyResult result, int who){
//        getInstance()._startRequest(url,result,who);
//    }

    // 其他: 带请求头,带请求方法的请求
    // 对内提供
    private void _startRequest(int method, String url, final ImageVolleuResult result, final int who, final Map<String, String> heads) {
        JsonObjectRequest jor = new JsonObjectRequest
                (method, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        result.success(response.toString(), who);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        result.failure();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return heads;
            }
        };
        // 加入请求队列
        addQueue(jor);
    }

    /**
     * 对外提供带请求头的方法
     *
     * @param method
     * @param url
     * @param result
     * @param who
     * @param heads
     */
    public void startRequest(int method, String url, final ImageVolleuResult result, final int who, final Map<String, String> heads) {
        _startRequest(method, url, result, who, heads);
    }


    /**
     * 对内提供请求方法(在里面处理逻辑)
     * 请求方法 (对内提供,将内部逻辑全部封装)
     *
     * @param url    网址
     * @param result 网络请求结果接口对象
     * @param who    区分是谁发出的请求
     */
    private void _startRequest(String url, final ImageVolleuResult result, final int who) {
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 处理请求结果
                result.success(response, who);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        // 加入请求队列
        // 保证必须为单例
//        getInstance().addQueue(sr);
        addQueue(sr);
    }

    /**
     * 把请求加入请求队列
     * 只有本单例类使用,权限私有
     *
     * @param request 请求 StringRequest
     *                还可以使用ImageRequest,JsonObjectRequest
     *                也可以自定义请求extends Request<T>
     */
    private void addQueue(Request request) {
        if (queue != null) {
            queue.add(request);
        }
    }

    /*************图片缓存加载******************/
    /**
     * 对外提供
     */
    public void loadImage(String imgUrl, ImageView imageView) {
        _loadImage(imgUrl, imageView);
    }

    /**
     * 对内提供
     */
    private void _loadImage(String imgUrl, ImageView imageView) {
        ImageLoader.ImageListener imageListener =
                ImageLoader.getImageListener
                        (imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        imageLoader.get(imgUrl, imageListener);
    }

    /**
     * 可以传入加载默认图片和失败图片的加载方法
     *
     * @param url          图片网址 eg."http://www.xxx.jpg"
     * @param imageView    显示的ImageView
     * @param defaultImgId 默认的图片 eg. R.mipmap.xxx
     * @param errorImgId   失败的图片 eg. R.mipmap.xxx
     */
    private void _loadImage(String url, ImageView imageView, int defaultImgId, int errorImgId) {
        ImageLoader.ImageListener imageListener =
                ImageLoader.getImageListener
                        (imageView, defaultImgId, errorImgId);
        imageLoader.get(url, imageListener);
    }

    public void loadImage(String url, ImageView imageView, int defaultImgId, int errorImgId) {
        _loadImage(url, imageView, defaultImgId, errorImgId);
    }

}
