package com.lanou3g.giltsay.utils;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.squareup.picasso.Downloader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by dllo on 16/9/26.
 * 自定义的Volley请求
 */
public class InputStreamRequestHelper extends Request<InputStream> {
    private Response.Listener<InputStream> linstener;

    public InputStreamRequestHelper(int method, String url, Response.ErrorListener listener, Response.Listener<InputStream> linstener) {
        super(method, url, listener);
        this.linstener = linstener;
    }

    public InputStreamRequestHelper(String url, Response.Listener<InputStream> linstener, Response.ErrorListener err) {
        this(Method.GET, url, err, linstener);


    }

    @Override
    protected Response<InputStream> parseNetworkResponse(NetworkResponse response) {
        InputStream is = new ByteArrayInputStream(response.data);
        return Response.success(is, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(InputStream response) {
        linstener.onResponse(response);
    }
}
