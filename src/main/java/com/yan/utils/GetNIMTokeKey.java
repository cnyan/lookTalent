package com.yan.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/22.
 */
public class GetNIMTokeKey {

    public static JSONObject getTokenKey(String account) throws Exception {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://api.netease.im/nimserver/user/create.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = "374e40f09d983c7c6f01ba15c5175b77";
        String appSecret = "e18f7a591607";
        String nonce = "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", account));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        // System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
//        if(!jsonObject.get("code").toString().equals("200")){
//            return jsonObject.get("code").toString();
//        }
//        //解析返回结果
//        String tokenKey = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8")).getJSONObject("info").get("token").toString();
        return jsonObject;
    }
}
