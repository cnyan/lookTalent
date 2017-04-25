package com.yan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yan.entity.HunterAccount;
import com.yan.repository.HunterAccountRepository;
import com.yan.utils.GetNIMTokeKey;
import com.yan.utils.ResultMsg;
import com.yan.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 闫继龙 on 2017/4/22.
 * 求职者注册登录接口
 */
@RestController
@RequestMapping("/hunter/account")
public class HunterAccountController {
    @Autowired
    private HunterAccountRepository hunterAccountRepository;


    /**
     * 求职者注册方法
     *
     * @param hunterAccount
     * @return
     */
    @PostMapping("regist")
    public ResultMsg hunterRegist(@RequestBody HunterAccount hunterAccount) {
        System.out.println("求职者注册API");
        ResultMsg resultMsg = new ResultMsg() ;

        try {
            JSONObject object = GetNIMTokeKey.getTokenKey(hunterAccount.getHunterAccount());
            if(!object.get("code").toString().equals("200")){
                //返回结果错误，返回错误信息与状态码
                resultMsg = new ResultMsg(object.get("code").toString(),object.get("desc").toString(),null);
                return resultMsg;
             }

            //解析返回正确结果
            hunterAccount.setTokenKey(object.getJSONObject("info").get("token").toString());
            //执行保存
            hunterAccountRepository.save(hunterAccount);
            resultMsg = new ResultMsg(ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrcode(), ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrmsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMsg;
    }

}
