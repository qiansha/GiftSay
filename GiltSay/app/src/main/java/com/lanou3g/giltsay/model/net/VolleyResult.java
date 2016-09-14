package com.lanou3g.giltsay.model.net;

/**
 * Created by dllo on 16/9/14.
 * 网络请求结果接口
 */
public interface VolleyResult {
    void success(String resultStr);
    void failure();

}
