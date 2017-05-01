package com.yan.utils;

/**
 * Created by 闫继龙 on 2017/4/22.
 */
public enum ResultStatusCode {
//    OK("0", "OK"),
//    SYSTEM_ERR("30001", "System error"),//系统错误
//    INVALID_CLIENTID(30003, "Invalid clientid"),//无效的ClientID
//    INVALID_PASSWORD(30004, "User name or password is incorrect"),//用户名或密码不正确
//    INVALID_CAPTCHA(30005, "Invalid captcha or captcha overdue"),//验证码无效或逾期
//    INVALID_TOKEN(30006, "Invalid token"),//无效的标记
//    ID_NON_EXISTENT(30007,"ID query results for null"),//id查询结果为空
//    PARAMETER_IS_EMPTY(30008,"Parameter is empty"),//参数为空
//    NOT_FIND_RESULT(30009,"Find result is empty"),//查询结果为空

    //网易云信 状态码200、403、414、416、431、500
    NIM_TOKENKEY_GET_SUCCESS("200","regist success"),
    ERROR_ACCOUNT("4004","User name or password is incorrect")//用户名或密码不正确
    ;

    private String errcode;
    private String errmsg;

    ResultStatusCode() {
    }

    ResultStatusCode(String errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
