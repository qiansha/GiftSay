package com.lanou3g.giltsay.model.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lanou3g.giltsay.ui.app.GiftApp;

/**
 * Created by dllo on 16/9/14.
 * Volley的单例类
 */
public class VolleyInstance {
    private RequestQueue requestQueue;
    private static VolleyInstance instance;
    private VolleyInstance(){
        requestQueue = Volley.newRequestQueue(GiftApp.getContext());
    }
    public static VolleyInstance getInstance(){
        if (instance == null){
            synchronized (VolleyInstance.class){
                if (instance == null){
                    instance = new VolleyInstance();
                }
            }
        }
        return instance;
    }
    public void startRequest(String url,final VolleyResult  result){
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                  result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               result.failure();
            }
        });
        requestQueue.add(sr);
    }
}
