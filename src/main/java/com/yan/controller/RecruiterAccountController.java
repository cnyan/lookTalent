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

import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/26.
 */
@RestController
@RequestMapping("/recruiter/account")
public class RecruiterAccountController {

    @Autowired
    private RecruiterAccountRepository recruiterAccountRepository;

    /**
     * 招聘者注册方法
     *
     * @param recruiterAccount
     * @return
     */
    @RequestMapping("regist")
    public ResultMsg recruiterRegist(@RequestBody RecruiterAccount recruiterAccount) {

        System.out.println("招聘者注册API");
        ResultMsg resultMsg = new ResultMsg();

        try {
            JSONObject object = GetNIMTokenKey.getTokenKey(recruiterAccount.getRecruiterAccount(), recruiterAccount.getName());
            if (!object.get("code").toString().equals("200")) {
                //返回结果错误，返回错误信息与状态码
                resultMsg = new ResultMsg(object.get("code").toString(), object.get("desc").toString(), null);
                return resultMsg;
            }
            System.out.println("网易云信注册结果：" + object);

            //返回网易token_key结果，hunterAccount设置token_key
            recruiterAccount.setTokenKey(object.getJSONObject("info").get("token").toString());
            //hunterAccount的密码进行md5 加密
            recruiterAccount.setPassword(CheckSumBuilder.getMD5(recruiterAccount.getPassword()));
            //执行保存
            recruiterAccountRepository.save(recruiterAccount);
            resultMsg = new ResultMsg(ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrcode(), ResultStatusCode.NIM_TOKENKEY_GET_SUCCESS.getErrmsg(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMsg;

    }

    /**
     * 招聘者登录
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("login")
    public ResultMsg loginToApp(@RequestBody JSONObject jsonObject) {

        String recruiter_account = jsonObject.get("recruiterAccount").toString();
        String password = CheckSumBuilder.getMD5(jsonObject.get("password").toString());

        List<RecruiterAccount> recruiterAccountList =
                recruiterAccountRepository.loginToApp(recruiter_account, password);

        if (recruiterAccountList.size() > 0) {
            RecruiterAccount recruiterAccount = recruiterAccountList.get(0);
            recruiterAccount.setPassword("");
            System.out.println(recruiterAccount);
            return new ResultMsg("200", "success", recruiterAccount);
        }

        return new ResultMsg(ResultStatusCode.ERROR_ACCOUNT.getErrcode(),
                ResultStatusCode.ERROR_ACCOUNT.getErrmsg(), null);
    }

    /**
     * 招聘者修改账号密码
     * @param jsonObject
     * @return
     */
    @RequestMapping("newpassword")
    public ResultMsg updateNewPassword(@RequestBody JSONObject jsonObject) {

        String hunter_account = jsonObject.get("recruiterAccount").toString();
        String password = CheckSumBuilder.getMD5(jsonObject.get("newPassword").toString());

        //根据账号查找招聘者
        List<RecruiterAccount> recruiterAccountList =
                recruiterAccountRepository.findRecruiterAccountByRecruiterAccount(hunter_account);

        if (recruiterAccountList.size() > 0){
            RecruiterAccount recruiterAccount = recruiterAccountList.get(0);
            recruiterAccount.setPassword(password);
            recruiterAccountRepository.save(recruiterAccount);
            return new ResultMsg("200","success",null);
        }
        return new ResultMsg("4004","update new password fail",null);
    }

    @RequestMapping("updateInfo")
    public ResultMsg updateHunterAccountInfo(@RequestBody RecruiterAccount recruiterAccount) {

        //根据账号查找招聘者
        List<RecruiterAccount> recruiterAccountList = recruiterAccountRepository.
                findRecruiterAccountByRecruiterAccount(recruiterAccount.getRecruiterAccount());

        if (recruiterAccountList.size() > 0) {
            RecruiterAccount newRecruiterAccount = recruiterAccountList.get(0);
            newRecruiterAccount.setRecruiterAccount(recruiterAccount.getRecruiterAccount());
            newRecruiterAccount.setName(recruiterAccount.getName());
            newRecruiterAccount.setHeadImage(recruiterAccount.getHeadImage());

            recruiterAccountRepository.save(newRecruiterAccount);
            return new ResultMsg("200","success",null);
        }
        return new ResultMsg("4004","update person info fail",null);
    }

}
