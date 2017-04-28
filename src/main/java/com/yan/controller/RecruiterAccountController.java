package com.yan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yan.entity.RecruiterAccount;
import com.yan.repository.RecruiterAccountRepository;
import com.yan.utils.CheckSumBuilder;
import com.yan.utils.GetNIMTokenKey;
import com.yan.utils.ResultMsg;
import com.yan.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 闫继龙 on 2017/4/26.
 *
 */
@RestController
@RequestMapping("/recruiter/account")
public class RecruiterAccountController {

    @Autowired
    private RecruiterAccountRepository recruiterAccountRepository;

    @RequestMapping("regist")
    public ResultMsg recruiterRegist(@RequestBody RecruiterAccount recruiterAccount){

        System.out.println("招聘者注册API");
        ResultMsg resultMsg = new ResultMsg() ;

        try {
            JSONObject object = GetNIMTokenKey.getTokenKey(recruiterAccount.getRecruiterAccount(),recruiterAccount.getName());
            if(!object.get("code").toString().equals("200")){
                //返回结果错误，返回错误信息与状态码
                resultMsg = new ResultMsg(object.get("code").toString(),object.get("desc").toString(),null);
                return resultMsg;
            }
            System.out.println("网易云信注册结果："+object);

            //返回网易token_key结果，hunterAccount设置token_key
            recruiterAccount.setTokenKey(object.getJSONObject("info").get("token").toString());
            //hunterAccount的密码进行md5 加密
            recruiterAccount.setPassword(CheckSumBuilder.getMD5(recruiterAccount.getPassword()));
            //执行保存
            recruiterAccountRepository.save(recruiterAccount);
            resultMsg = new ResultMsg(ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrcode(), ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrmsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMsg;

    }


}
