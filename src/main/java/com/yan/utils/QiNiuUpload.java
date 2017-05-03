package com.yan.utils;


import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;

import java.io.File;

/**
 * Created by 闫继龙 on 2017/5/3.
 * 七牛上传文件工具类
 */
public class QiNiuUpload {

    private static final String ACCESS_KEY = "UUeyLQ5aDFIYP2lYMECf72ukk403ww3SPrzUFkR3";
    private static final String SECRET_KEY = "GQ4ull-1iQy7OYwiR_pYtXs3JYTM_i_f5pE8qHx-";
    private static final String UP_TOKEN = "UUeyLQ5aDFIYP2lYMECf72ukk403ww3SPrzUFkR3:szY0s_AzckomqVKfB-Mbe4j7kCU=:eyJzY29wZSI6Imxvb2t0YWxlbnQiLCJkZWFkbGluZSI6MzMyMTA4NTE0MX0=";
    private static final String BUCKET_NAME = "looktalent";
    /**
     * 上传图片到七牛云存储
     * @param
     * @param fileName
     */
    public static String uploadFile(File imageFile, String fileName) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
       // ...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        String key = null;

        try {
           // Response response = uploadManager.put(localFilePath, key, UP_TOKEN);
            Response response = uploadManager.put(imageFile,null,UP_TOKEN);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //System.out.println(putRet.key);
            //System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    public static String uploadFile(byte[] imageData, String fileName){

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        // ...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        String key = null;

        try {
            // Response response = uploadManager.put(localFilePath, key, UP_TOKEN);
            Response response = uploadManager.put(imageData,null,UP_TOKEN);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //System.out.println(putRet.key);
            //System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "up qiniu error";
    }


    public QiNiuUpload() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
