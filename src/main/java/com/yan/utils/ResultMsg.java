package com.yan.utils;

/**
 * Created by 闫继龙 on 2017/4/22.
 * 请求返回结果类型
 */
public class ResultMsg {

    //状态编码
    private String Code;
    //返回消息
    private String Message;
    //返回结果
    private Object Content;

    public ResultMsg() { }


    public ResultMsg(String code, String message, Object content) {
        Code = code;
        Message = message;
        Content = content;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getContent() {
        return Content;
    }

    public void setContent(Object content) {
        Content = content;
    }
}
